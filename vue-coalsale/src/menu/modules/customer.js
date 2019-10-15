const pre = '/customer/';

export default {
  path: '/customer',
  title: '客户管理',
  header: 'home',
  icon: 'md-contacts',
  auth: ['customer'],
  children: [
    {
      path: `${pre}cusBase`,
      auth: ['cusBase'],
      title: '客户列表'
    }
  ]
}
