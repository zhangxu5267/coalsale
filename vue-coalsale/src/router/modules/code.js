import BasicLayout from '@/layouts/basic-layout';

export default {
  path: '/code',
  name: 'code',
  redirect: {
    name: 'datatable'
  },
  meta: {
    auth: ['code']
  },
  component: BasicLayout,
  children: [
    {
      path: 'datatable',
      name: 'datatable',
      meta: {
        auth: ['datatable'],
        title: '数据库表'
      },
      component: () => import('@/view/com/drzyl/code/business/datatable/datatable.vue')
    },
    {
      path: 'coding',
      name: 'coding',
      meta: {
        auth: ['coding'],
        title: '生成代码'
      },
      component: () => import('@/view/com/drzyl/code/business/coding/coding.vue')
    }
  ]
};
