<template>
    <GlobalFooter class="i-copyright" :copyright="copyright" />
</template>
<script>
    export default {
        name: 'i-copyright',
        data () {
            return {
                copyright: '陕西省煤炭运销（集团）有限责任公司 版权所有    Copyright © 2013-2019 DHC Corporation All Rights Reserved'
            }
        }
    }
</script>
<style lang="less">
    .i-copyright{
        flex: 0 0 auto;
    }
</style>
