import axios from 'axios'
import QS from 'qs'
import { Message } from 'element-ui'
import vue from '../main'

if (process.env.NODE_ENV === 'development') {
  axios.defaults.baseURL = 'http://127.0.0.1:9527'
} else if (process.env.NODE_ENV === 'debug') {
  axios.defaults.baseURL = 'http://127.0.0.1:9527'
} else if (process.env.NODE_ENV === 'production') {
  axios.defaults.baseURL = ''
}

axios.defaults.timeout = 10000

axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF-8'

axios.interceptors.request.use(
  config => {
    const token = sessionStorage.getItem('token')
    console.log(token)
    token && (config.headers.token = token)
    return config
  },
  error => {
    return Promise.error(error)
  }
)

axios.interceptors.response.use(
  response => {
    if (response.status === 200) {
      var entity = response.data
      if (entity === undefined || entity.code === undefined) {
        Message.error('数据异常！请联系liuawu')
        return Promise.reject(response)
      }
      if (entity.code === 0) {
        return Promise.resolve(response)
      } else if (entity.code === -1) {
        Message.error(entity.message)
        sessionStorage.removeItem('token')
        setTimeout(() => {
          vue.$router.replace({
            path: '/login',
            query: {
              redirect: vue.$router.currentRoute.fullPath
            }
          })
        }, 1000)
        return Promise.reject(entity)
      } else {
        Message.error(entity.message)
        return Promise.reject(entity)
      }
    } else {
      return Promise.reject(response)
    }
  },
  error => {
    return Promise.reject(error)
  }
)

export function get (url, params) {
  return new Promise((resolve, reject) => {
    axios.get(url, {
      params: params
    }).then(res => {
      resolve(res.data)
    }).catch(err => {
      reject(err)
    })
  })
}

export function post (url, params) {
  return new Promise((resolve, reject) => {
    axios.post(url, QS.stringify(params))
      .then(res => {
        resolve(res.data)
      }).catch(err => {
        reject(err.data)
      })
  })
}
