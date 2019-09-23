<template>
    <el-card>
        <div slot="header">
            <span>日记列表</span>
            <el-button style="float:right" size="medium" @click="addArticle" >新增日记</el-button>
        </div>
        <el-table :data="list">
          <el-table-column label="日记标题" prop="articleName"></el-table-column>
          <el-table-column label="日记描述" prop="articleDesc"></el-table-column>
        </el-table>
        <el-pagination :total="total" :current-page="currentPage" :page-size="pageSize" @current-change="handleCurrentChange" layout="prev,pager,next"></el-pagination>
    </el-card>
</template>
<script>
import { ＨttpqueryArticleList } from '@/api/api'
export default {
  data () {
    return {
      userSkillId: '',
      pageSize: 10,
      currentPage: 1,
      total: 0,
      list: []
    }
  },
  mounted () {
    var param = this.$route.params
    if (param !== undefined) {
      this.userSkillId = param.userSkillId
    }
    this.queryArticleList()
  },
  methods: {
    addArticle () {
      this.$router.push({ name: 'articleDetails' ,params:{userSkillId:this.userSkillId}})
    },
    handleCurrentChange (val) {
      this.currentPage = val
      this.queryArticleList()
    },
    queryArticleList () {
      var param = {}
      if (this.userSkillId !== undefined && this.userSkillId !== '') {
        param = {
          userSkillId: this.userSkillId,
          pageSize: this.pageSize,
          currentPage: this.currentPage
        }
      } else {
        param = {
          pageSize: this.pageSize,
          currentPage: this.currentPage
        }
      }
      ＨttpqueryArticleList(param).then(res => {
        if (res.code === 0) {
          this.total = res.data.total
          this.list = res.data.list
        }
      })
    }
  }
}
</script>
