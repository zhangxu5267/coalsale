<template>
    <i-link class="i-layout-header-logo" :class="{ 'i-layout-header-logo-stick': !isMobile }" to="/">
        <img src="@/assets/images/smyxjt_logo_03.png" v-if="isMobile">
        <img src="@/assets/images/smyxjt_logo_03.png" v-else-if="headerTheme === 'light'">
        <img src="@/assets/images/smyxjt_logo_03.png" v-else>
    </i-link>
</template>
<script>
    import { mapState } from 'vuex';

    export default {
        name: 'iHeaderLogo',
        computed: {
            ...mapState('admin/layout', [
                'isMobile',
                'headerTheme'
            ])
        }
    }
</script>
