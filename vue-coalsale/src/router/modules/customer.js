import BasicLayout from '@/layouts/basic-layout';

const meta = {
  auth: true
};

const pre = 'customer-';

export default {
  path: '/customer',
  name: 'customer',
  redirect: {
    name: `${pre}customer`
  },
  meta: {
    auth: ['customer']
  },
  component: BasicLayout,
  children: [
    {
      path: 'cusBase',
      name: `${pre}customer`,
      meta: {
        auth: ['cusBase'],
        title: '客户管理'
      },
      component: () => import('@/view/com/drzyl/cus/cusBase/cusBase.vue')
    }
  ]
};
