<template>
    <!-- <Select v-model="model1" style="width:300px;margin-right: 20px;">
        <Option v-for="item in cityList" :value="item.value" :key="item.value">{{ item.label }}</Option>
    </Select> -->
    <Dropdown @on-change="handleChange" style="margin-right: 20px;">
          华中办事处/财务部/会计
          <Icon type="ios-arrow-down"></Icon>
        <DropdownMenu v-for="post in this.postSet" :key="post.index" slot="list">
            <DropdownItem>{{post.namePath + '/' + post.postName}}</DropdownItem>
        </DropdownMenu>
    </Dropdown>
</template>
<script>
import { mapState, mapMutations, mapActions, mapGetters } from 'vuex'
import PostQuery from '@/view/com/drzyl/sign/post/PostQuery'
    export default {
        data () {
            return {
                postQuery: new PostQuery(),
                postSpinShow: false,
                postPageShow: true,
                postQueryPoptipShow: false,
                postQuerySubmitting: false,
                postRows: 10,
                postPage: 1,
                postSet: [],
                // cityList: [
                //     {
                //         value: 'New York',
                //         label: '华中办事处/财务部/会计'
                //     },
                //     {
                //         value: 'London',
                //         label: '华中办事处/财务部/财务部副经理'
                //     },
                //     {
                //         value: 'Sydney',
                //         label: '华中办事处/质价部/质价部化验室技术管理'
                //     },
                //     {
                //         value: 'Ottawa',
                //         label: '榆林销售公司/市场部/市场部合同管理'
                //     },
                //     {
                //         value: 'Paris',
                //         label: '榆林销售公司/调运部/调运部副经理'
                //     },
                //     {
                //         value: 'Canberra',
                //         label: '榆林销售公司/财务部/财务部副经理'
                //     }
                // ],
                // model1: 'London'
            }
        },
        methods: {
            ...mapActions('postStore', [
                'pagingQueryPostVO'
            ]),
            getPostSet () {
                this.postSpinShow = true
                this.postPageShow = true
                this.pagingQueryPostVO({ postQuery: {}, rows: this.postRows, page: this.postPage }).then(res => {
                    if (res.data.success) {
                    this.postSet = res.data.data
                    this.postCount = res.data.count
                    this.setPostSelectRow([])
                    setTimeout(() => { this.postSpinShow = false }, 700)
                    } else {
                    this.$Message.error({ content: res.data.msg, duration: 6 })
                    setTimeout(() => { this.postSpinShow = false }, 700)
                    }
                }).catch(result => {
                    this.$Message.error({ content: result.response.statusText, duration: 6 })
                    setTimeout(() => { this.postSpinShow = false }, 700)
                })
            },
            handleChange () {
              this.$Message.success('岗位切换成功');
            },
        },
        mounted () {
            this.getPostSet()
        }
    }
</script>

<style>
  /* .Cascader{
    display: inline-block;
    width: 300px;
    box-sizing: border-box;
    vertical-align: middle;
    color: #515a6e;
    font-size: 14px;
    margin-right: 20px;
  } */
  .ivu-select-selection {
    border: 0px;
  }
  .ivu-select-visible .ivu-select-selection{
    box-shadow: 0px;
  }
</style>