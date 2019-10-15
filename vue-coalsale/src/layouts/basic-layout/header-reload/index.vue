<template>
    <span class="i-layout-header-trigger" :class="{ 'i-layout-header-trigger-min': showSiderCollapse }" @click="handleReload">
        <Icon type="md-refresh" />
    </span>
</template>
<script>
    import { mapState } from 'vuex';

    export default {
        name: 'iHeaderReload',
        computed: {
            ...mapState('admin/layout', [
                'isMobile',
                'showSiderCollapse'
            ])
        },
        methods: {
            handleReload () {
                this.$emit('on-reload');
            }
        }
    }
</script>
