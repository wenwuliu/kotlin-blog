import { get, post } from './belphegorAxios'

const bpg = '/belphegor'

// 登录方法
export const HttpLogin = p => post(bpg + '/login', p)

export const HttpRegister = p => post(bpg+'/register',p)

export const HttpQuerySkillList = p => get(bpg+'/skill/getSkillList',p)

export const HttpAddSkill = p => post(bpg+'/skill/addSkill',p)