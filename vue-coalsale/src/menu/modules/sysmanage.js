export default {
  path: '/sysmanage',
  title: '系统管理',
  header: 'home',
  icon: 'md-aperture',
  auth: ['sysmanage'],
  children: [
    {
      path: '/sysmanage/dict',
      auth: ['dict'],
      icon: 'ios-book',
      title: '数据字典'
    },
    {
      path: '/sysmanage/account',
      auth: ['account'],
      icon: 'ios-people',
      title: '账号管理'
    },
    {
      path: '/sysmanage/session',
      auth: ['session'],
      icon: 'ios-chatbubbles',
      title: '会话管理'
    },
    {
      path: '/sysmanage/loginLog',
      auth: ['loginLog'],
      icon: 'md-finger-print',
      title: '登录日志'
    },
    {
      path: '/sysmanage/org',
      auth: ['org'],
      icon: 'ios-apps',
      title: '组织机构'
    },
    {
      path: '/sysmanage/post',
      auth: ['post'],
      icon: 'ios-body',
      title: '岗位'
    },
    {
      path: '/sysmanage/staff',
      auth: ['staff'],
      icon: 'md-contacts',
      title: '员工'
    },
    {
      path: '/sysmanage/role',
      auth: ['role'],
      icon: 'ios-construct',
      title: '角色权限'
    },
    {
      path: '/sysmanage/orgTree',
      auth: ['orgTree'],
      icon: 'ios-construct',
      title: '组织结构'
    }
  ]
}
