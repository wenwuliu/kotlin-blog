<template>
    <el-dialog title="新增技能" :visible="isVisible" @close="close">
        <el-form
        v-model="skill">
            <el-form-item label="技能名称">
                <el-input v-model="skill.skillName" placeholder=""></el-input>
            </el-form-item>
            <el-form-item label="技能描述">
                <el-input v-model="skill.skillDesc" placeholder=""></el-input>
            </el-form-item>
            <el-button type="primary" style="text-align:center" @click='addSkill'>新增</el-button>
        </el-form>
    </el-dialog>
</template>
<script>
import {HttpAddSkill} from '@/api/api'
export default {
    data(){
        return{
            isVisible:false,
            skill:{
                skillName:'',
                skillDesc:''
            }
        }
    },
    methods:{
        show(){
            this.isVisible = true;
        },
        close(){
            this.isVisible = false;
            this.skill = {
                skillName:'',
                skillDesc:''
            }
        },
        addSkill(){
            if(this.skill.skillName === ''){
                this.$message({message:"请输入技能名称",type:'warning'});
                return;
            }
            HttpAddSkill(this.skill).then(res =>{
                if(res.code === 0){
                    this.$message("技能添加成功")
                    this.$emit('querySkillList')
                    this.close()
                }
            })
        }
    }
}
</script>