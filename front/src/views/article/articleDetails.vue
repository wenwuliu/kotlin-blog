<template>
    <el-card>
        <div slot="header">
            <el-form :model="article" label-width="100px">
              <el-form-item label="日记标题">
                  <el-input style="width:80%" v-model="article.title" placeholder=""></el-input>
              </el-form-item>
            <el-form-item label="日记描述">
                  <el-input :autosize="{ minRows: 2, maxRows: 5}" style="width:80%" type="textarea" v-model="article.desc" placeholder=""></el-input>
              </el-form-item>
            </el-form>
        </div>
        <div style="height:500px">
        <vue-editor @handleContentChange="handleContentChange"></vue-editor>
        </div>
        <div>
            <el-button @click="addArticle" type="">完成</el-button>
        </div>
    </el-card>
</template>
<script>
import { HttpAddArticle } from '@/api/api'
import vueEditor from '@/components/vueEditor'
export default {
  components: { vueEditor },
  data () {
    return {
      article: {
        title: '',
        desc: '',
        content: '',
        userSkillId: ''
      },
      content: ''
    }
  },
  mounted () {
    var param = this.$route.params
    if (param !== undefined) {
      this.article.userSkillId = param.userSkillId
    }
  },
  methods: {
    handleContentChange (content) {
      this.content = content
    },
    addArticle () {
      if (this.article.title === '') {
        this.$message({ type: 'warning', message: '请输入标题' })
        return
      }
      this.article.content = this.content
      HttpAddArticle(this.article).then(res => {
        if (res.code === 0) {
          this.$message({ message: '新增成功', type: 'success' })
          this.$router.push({ path: '/home' })
        }
      })
    }
  }
}
</script>
