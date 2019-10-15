<style lang="less">
</style>

<template>
  <div>
    <div v-if="type === 'select'">
      <FormItem :label="formItemLocalLabel" :prop="formItemProp" :label-width="formItemLabelWidth">
        <Select :size="size" :value="value" clearable filterable @on-change="changeDictValue($event)">
          <Option v-for="item in dictValueSet" :value="item.code" :key="item.code">{{ item.displayName }}</Option>
        </Select>
      </FormItem>
    </div>
    <div v-if="type === 'radio'">
      <FormItem :label="formItemLocalLabel" :prop="formItemProp" :label-width="formItemLabelWidth">
        <RadioGroup :type="radioType" :size="size" :value="value" :vertical="radioVertical" @on-change="changeDictValue($event)">
          <Radio v-for="item in dictValueSet" :label="item.code" :key="item.code">{{ item.displayName }}</Radio>
        </RadioGroup>
      </FormItem>
    </div>
  </div>
</template>

<script>
import { mapActions } from 'vuex'

export default {
  name: 'i-dict',
  props: {
    // 下拉框或单选框 默认下拉框
    type: {
      type: String,
      default: 'select'
    },
    // 组件尺寸
    size: {
      type: String
    },
    // 单选框按钮样式
    radioType: {
      type: String
    },
    // 单选框垂直显示
    radioVertical: {
      type: Boolean,
      default: false
    },
    // 数据字典标识
    dictKey: {
      type: String,
      required: true
    },
    // 表单项名称 传入名称会强制覆盖数据字典名称
    formItemLabel: {
      type: String,
      default: ''
    },
    // 表单验证
    formItemProp: {
      type: String,
      required: true
    },
    // 表单项名称宽度
    formItemLabelWidth: {
      type: Number,
      default: 120
    },
    // 双向数据绑定值
    value: [String, Number]
  },
  data () {
    return {
      formItemLocalLabel: '',
      dictValueSet: []
    }
  },
  methods: {
    ...mapActions('dictStore', [
      'queryDict'
    ]),
    ...mapActions('dictValueStore', [
      'queryDictValue'
    ]),
    getDictData () {
      this.queryDict({ dictKey: this.dictKey }).then(res => {
        if (res.data.success) {
          if (!this.formItemLabel) {
            this.formItemLocalLabel = `${res.data.data[0].dictName}：`
          }
          this.queryDictValue({ dictId: res.data.data[0].dictId }).then(res => {
            if (res.data.success) {
              this.dictValueSet = res.data.data
            }
          })
        }
      })
    },
    changeDictValue (value) {
      if (value) {
        this.$emit('input', value)
        this.$emit('on-change', value)
      } else {
        this.$emit('input', null)
        this.$emit('on-change', null)
      }
    }
  },
  mounted () {
    if (this.formItemLabel) {
      this.formItemLocalLabel = this.formItemLabel
    }
    this.getDictData()
  }
}
</script>
