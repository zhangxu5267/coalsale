import BasicLayout from '@/layouts/basic-layout';

export default {
  path: '/sysmanage',
  name: 'sysmanage',
  redirect: {
    name: 'datatable'
  },
  meta: {
    auth: ['sysmanage']
  },
  component: BasicLayout,
  children: [
    {
      path: 'dict',
      name: 'dict',
      meta: {
        auth: ['dict'],
        title: '数据字典'
      },
      component: () => import('@/view/com/drzyl/dict/business/dict/dict.vue')
    },
    {
      path: 'account',
      name: 'account',
      meta: {
        auth: ['account'],
        title: '账号管理'
      },
      component: () => import('@/view/com/drzyl/sign/account/account.vue')
    },
    {
      path: 'session',
      name: 'session',
      meta: {
        auth: ['session'],
        title: '会话管理'
      },
      component: () => import('@/view/com/drzyl/sign/session/session.vue')
    },
    {
      path: 'loginLog',
      name: 'loginLog',
      meta: {
        auth: ['loginLog'],
        title: '登录日志'
      },
      component: () => import('@/view/com/drzyl/sign/loginLog/loginLog.vue')
    },
    {
      path: 'org',
      name: 'org',
      meta: {
        auth: ['org'],
        title: '组织机构'
      },
      component: () => import('@/view/com/drzyl/sign/org/org.vue')
    },
    {
      path: 'post',
      name: 'post',
      meta: {
        auth: ['post'],
        title: '岗位'
      },
      component: () => import('@/view/com/drzyl/sign/post/post.vue')
    },
    {
      path: 'staff',
      name: 'staff',
      meta: {
        auth: ['staff'],
        title: '员工'
      },
      component: () => import('@/view/com/drzyl/sign/staff/staff.vue')
    },
    {
      path: 'role',
      name: 'role',
      meta: {
        auth: ['role'],
        title: '角色权限'
      },
      component: () => import('@/view/com/drzyl/sign/role/role.vue')
    },
    {
      path: 'orgTree',
      name: 'orgTree',
      meta: {
        auth: ['orgTree'],
        title: '组织结构'
      },
      component: () => import('@/view/com/drzyl/sign/orgTree/index.vue')
    }
  ]
};
