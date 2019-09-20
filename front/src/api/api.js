import { get, post } from './belphegorAxios'

const bpg = '/belphegor'

// 登录方法
export const HttpLogin = p => post(bpg + '/login', p)
