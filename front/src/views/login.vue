<template>
<div>
<el-card style="margin-left:20%;margin-right:20%">
  <div slot="header">
    <span>登录</span>
  </div>
<el-form :model="loginForm" label-width="30%">
  <el-form-item label="用户名">
    <el-input v-model="loginForm.username" class="login-input" placeholder=""></el-input>
  </el-form-item>
  <el-form-item label="密码">
    <el-input v-model="loginForm.password" class="login-input" type="password" placeholder=""></el-input>
  </el-form-item>
  <el-button style="text-align:center" @click="login" type="">登录</el-button>
</el-form>
</el-card>
</div>
</template>
<script>
import { HttpLogin } from '@/api/api'

export default {
  data () {
    return {
      loginForm: {
        username: '',
        password: ''
      }
    }
  },
  methods: {
    login () {
      HttpLogin(this.loginForm).then(res => {
        if (res.code === 0) {
          var token = res.data.token
          sessionStorage.setItem('token', token)
          this.$router.push({path:'/home'})
        }
      }).catch(err => {
        // do noting
        console.log(err)
      })
    }
  }
}
</script>

<style scoped>
.login-input{
  width:50%;
  margin-right:30%;
}

</style>
