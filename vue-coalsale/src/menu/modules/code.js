export default {
  path: '/code',
  title: '代码生成',
  header: 'home',
  icon: 'logo-freebsd-devil',
  auth: ['code'],
  children: [
    {
      path: '/code/datatable',
      auth: ['datatable'],
      icon: 'logo-tumblr',
      title: '数据库表'
    },
    {
      path: '/code/coding',
      auth: ['coding'],
      icon: 'logo-freebsd-devil',
      title: '生成代码'
    }
  ]
}
