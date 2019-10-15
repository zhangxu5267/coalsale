import BasicLayout from '@/layouts/basic-layout';

export default {
  path: '/homepage',
  redirect: {
    name: 'homepage'
  },
  component: BasicLayout,
  children: [
    {
      path: 'console',
      name: 'console',
      meta: {
        auth: ['homepage'],
        title: '主页'
      },
      component: () => import('@/view/com/drzyl/homepage/console/index.vue')
    },
    {
      path: 'workplace',
      name: 'workplace',
      meta: {
        auth: ['homepage'],
        title: '工作台'
      },
      component: () => import('@/view/com/drzyl/homepage/workplace/index.vue')
    }
  ]
};
