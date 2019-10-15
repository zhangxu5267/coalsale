import BasicLayout from '@/layouts/basic-layout';

const meta = {
  auth: true
};

const pre = 'dict-';

export default {
  path: '/dict',
  name: 'dict',
  redirect: {
    name: `${pre}dict`
  },
  meta,
  component: BasicLayout,
  children: [
    {
      path: 'dict',
      name: `${pre}dict`,
      meta: {
        ...meta,
        title: '数据字典'
      },
      component: () => import('@/view/com/drzyl/dict/business/dict/dict.vue')
    }
  ]
};
