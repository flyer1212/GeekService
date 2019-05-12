import Vue from 'vue'
import Router from 'vue-router'

import Main from '@/pages/Main'
import TaskMain from '@/pages/task/TaskMain'
import AccountMain from '@/pages/account/AccountMain'
import UserMain from '@/pages/userinfo/UserMain'

import MyPublish from '@/pages/userinfo/menuitems/MyPublish'
import UserDetail from '@/pages/userinfo/menuitems/UserDetail'
import ModifyPassword from '@/pages/userinfo/menuitems/ModifyPassword'
import FeedBack from '@/pages/userinfo/menuitems/FeedBack'
import PublishTask from '@/pages/userinfo/menuitems/PublishTask'
import MyTask from '@/pages/userinfo/menuitems/MyTask'
import TaskDetail from   '@/pages/task/TaskDetail'
import Login from '@/pages/login/Login'
import Register from '@/pages/register/Register'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/app',
      name: 'Main',
      component: Main
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/register',
      name: 'Register',
      component: Register
    },
    {
      path: '/app/task_main',
      name: 'TaskMain',
      component: TaskMain
    },
    {
      path: '/app/task_detail',
      name: 'TaskDetail',
      component: TaskDetail
    },
    {
      path: '/app/account_public_detail',
      name: 'AccountMain',
      component: AccountMain
    },
    {
      path: '/app/user_info',
      name: 'UserMain',
      component: UserMain,
      children: [
        {
          path: 'publishd-task',
          name: 'MyPublish',
          component: MyPublish
        },{
          path: 'user-detail',
          name:'UserDetail',
          component: UserDetail
        },{
          path: 'modify-password',
          name:'ModifyPassword',
          component: ModifyPassword
        },{
          path: 'feed-back',
          name:'FeedBack',
          component: FeedBack
        },{
          path: 'publish-task',
          name:'PublishTask',
          component: PublishTask
        },{
          path: 'my-task',
          name:'MyTask',
          component: MyTask
        },{
          path: '',
          component: UserDetail
        }
      ]
    }
  ]
})
