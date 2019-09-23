<template>
    <div>
        <el-card
            style="margin-left:20%;margin-right:20%;margin-top:20%;margin-bottom:20%">
            <div slot="header">
                <span>注册</span>
            </div>
            <el-form ref="registerForm" :model="loginForm" label-width="30%" :rules="rules">
                <el-form-item label="用户名" prop="userName">
                    <el-input v-model="loginForm.userName" class="register-input" placeholder=""></el-input>
                </el-form-item>
                <el-form-item label="密码" prop="password">
                    <el-input
                        v-model="loginForm.password"
                        class="register-input"
                        type="password"
                        placeholder=""></el-input>
                </el-form-item>
                <el-form-item label="确认密码" prop="passwordAgain">
                    <el-input
                        v-model="loginForm.passwordAgain"
                        class="register-input"
                        type="password"
                        placeholder=""></el-input>
                </el-form-item>
                <el-form-item label="生日">
                    <el-date-picker class="register-input"  v-model="loginForm.birthday" type="date" placeholder="" format="yyyy-MM-dd"></el-date-picker>
                </el-form-item>
                <el-form-item label="身高(cm)">
                    <el-input-number class='register-input'  v-model="loginForm.height"></el-input-number>
                    <template slot="append">cm</template>
                    <!-- <span style="float:right">cm</span> -->
                </el-form-item>
                <el-form-item label="体重(kg)">
                    <el-input-number class='register-input'  v-model="loginForm.weight" placeholder=""></el-input-number>
                    <!-- <span style="float:right">kg</span> -->
                </el-form-item>
                <el-button style="text-align:center" @click="register" type="">注册</el-button>
            </el-form>
        </el-card>
    </div>
</template>
<script>
    import {formatDate} from '@/util/DateUtil'
    import {HttpRegister} from '@/api/api'

    export default {
        data() {
            return {
                rules:{
                    password:[
                        {required:true,message:"请填写密码",trigger:'blur'}
                    ],
                    userName:[
                        {required:true,message:"请填写用户名",trigger:'blur'}
                    ],
                    passwordAgain:[
                        {required:true,message:"请再次填写密码",trigger:'blur'}
                    ]
                },
                loginForm: {
                    userName: '',
                    password: '',
                    passwordAgain:'',
                    birthday: '',
                    weight: 90,
                    height: 170
                }
            }
        },
        methods: {
            register() {
                if(this.loginForm.password != this.loginForm.passwordAgain){
                    this.$message.error('密码不一致')
                    return
                }
                this.$refs.registerForm.validate((valid) =>{
                    if(valid){
                        var data = {
                            userName: this.loginForm.userName,
                            password:this.loginForm.password,
                            birthday: formatDate(this.loginForm.birthday,'yyyy-MM-dd'),
                            weight:this.loginForm.weight,
                            height:this.loginForm.height
                        }
                        HttpRegister(data)
                            .then(res => {
                                if (res.code === 0) {
                                    this.$message.success("注册完成，请登录")
                                        this.$router
                                        .push({path: '/login'})
                                }
                            })
                            .catch(err => {
                                // do noting
                                console.log(err)
                            })
                    }
                })

                }
        }
    }
</script>

<style scoped="scoped">
    .register-input {
        width: 50%;
        margin-left: -50%;
    }
</style>