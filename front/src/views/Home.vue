<template>
  <div>
    <el-card>
        <div slot="header">
          <span>个人资料</span>
          <el-button style="float:right" @click="addSkill">新增技能</el-button>
        </div>
        <span>用户名:{{this.username}}</span>
        <el-table :data="skillList">
          <el-table-column label="技能名称" prop="skillName"></el-table-column>
          <el-table-column label="技能熟练度" prop="exp"></el-table-column>
          <el-table-column label="操作">
            <template slot-scope="scope">
              <el-button type="primary" @click="addArticle">新增日记</el-button>
            </template>
          </el-table-column>
        </el-table>
    </el-card>
    <add-skill @querySkillList='querySkillList' ref='addSkill'></add-skill>
  </div>
</template>

<script>
import addSkill from '@/views/skill/addSkill'
import {HttpQuerySkillList} from '@/api/api'
export default {
  name: 'home',
  components:{addSkill},
  mounted(){
    this.username = sessionStorage.getItem('username')
    this.querySkillList()
    console.log(this.user)
  },
  data(){
    return{
        username:'',
        skillList:[]
    }
  },
  methods:{
    addSkill(){
      this.$refs.addSkill.show()
    },
    querySkillList(){
      HttpQuerySkillList().then(res =>{
        if(res.code === 0){
          this.skillList = res.data
        }
      })
    }
  }
}
</script>
