<template>
    <quill-editor class="editor"
    ref="myTextEditor"
    v-model="content"
    :options="editorOption"
    @blur="onEditorBlur($event)"
    @focus="onEditorFocus($event)"
    @change="onEditorChange($event)">
    </quill-editor>
</template>
<script>
export default {
    data(){
        return{
            content:null,
            editorOption:{
                modules:{
                    toolbar:[
                        ["bold","italic","underline","strike"],
                        ["blockquote","code-block"],
                        [{header:1},{header:2}],
                        [{list:"ordered"},{list:"bullet"}],
                        [{script:"sub"},{script:"super"}],
                        [{indent:"-1"},{indent:"+1"}],
                        [{size:["small",false,"large","huge"]}],
                        [{header:[1,2,3,4,5,6,false]}],
                        [{color:[]},{background:[]}],
                        [{align:[]}],
                        ["clean"],
                        ["link","image","video"]
                    ],
                },
                placeholder:"",
                readOnly:false,
                theme:'snow',
                syntax:true
            }
        }
    },
    methods:{
        onEditorBlur(editor){},
        onEditorFocus(editor){},
        onEditorReady(editor){},
        onEditorChange(editor){
            this.$emit("handleContentChange",this.content)
        }
    }
}
</script>
<style scoped>
.editor{
    line-height: normal !important;
    height: 400px;
}
</style>