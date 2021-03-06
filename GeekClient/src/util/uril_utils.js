// 文件中使用的是这个, 所以每次要把换一下地址
// const docker_URLs =  [
//     {
//       value: "http://localhost:18002/task",
//       label: "请求所有的task"
//     },
//     {
//       value: "http://localhost:18002/task/task/",
//       label: "taskdetail"
//     },
//     {
//       value: "http://localhost:18000/auth/login",
//       label: "login"
//     },
//     {
//       value: "http://localhost:18001/user/register",
//       label: "register"
//     }
//   ];


// k8s and docker-compose 部署在服务器上， ui 也部署在服务器上使用
const requestURLs = [
  {
    value: "/task",
    label: "请求所有的task"
  },
  {
    value: "/task/task/",
    label: "taskdetail"
  },
  {
    value: "/auth/login",
    label: "login"
  },
  {
    value: "/user/register",
    label: "register"
  },
  {
    value: "/signtask",
    label: "signtask"
  },
  {
    // value: "ws://10.141.211.161:32677/ws",
    // value: "ws://geek-message-service:8282/ws",
    value: "ws://10.141.211.161:18009/ws",
    // value: "/ws",
    label: "websocket"
  },
  {
    value: "/msg",
    label: "webmsg"
  }
];

// k8s  部署在服务器上，但是ui 部署在本地电脑
// const requestURLs = [
//   {
//     value: "http://10.141.211.161:32002/task",
//     label: "请求所有的task"
//   },
//   {
//     value: "http://10.141.211.161:32002/task/task/",
//     label: "taskdetail"
//   },
//   {
//     value: "http://10.141.211.161:32000/auth/login",
//     label: "login"
//   },
//   {
//     value: "http://10.141.211.161:32001/user/register",
//     label: "register"
//   },
//   {
//     value: "http://10.141.211.161:32002/signtask",
//     label: "signtask"
//   },{
//     value: "ws://10.141.211.161:18009/ws",
//     label: "websocket"
//   },{
//      value: "http://10.141.211.161:18008/msg",
//     label: "webmsg"
// }
// ];


// docker-compose   部署在服务器上，但是ui 部署在本地电脑
// const requestURLs = [
//   {
//     value: "http://10.141.211.161:18002/task",
//     label: "请求所有的task"
//   },
//   {
//     value: "http://10.141.211.161:18002/task/task/",
//     label: "taskdetail"
//   },
//   {
//     value: "http://10.141.211.161:18000/auth/login",
//     label: "login"
//   },
//   {
//     value: "http://10.141.211.161:18001/user/register",
//     label: "register"
//   },
//   {
//     value: "http://10.141.211.161:18002/signtask",
//     label: "signtask"
//   },{
//     value: "ws://10.141.211.161:18009/ws",
//     label: "websocket"
//   }
// ];


// docker-compose   部署在服务器上，但是ui 部署在本地电脑
// const requestURLs = [
//   {
//     value: "http://localhost:18002/task",
//     label: "请求所有的task"
//   },
//   {
//     value: "http://localhost:18002/task/task/",
//     label: "taskdetail"
//   },
//   {
//     value: "http://localhost:18000/auth/login",
//     label: "login"
//   },
//   {
//     value: "http://localhost:18001/user/register",
//     label: "register"
//   },
//   {
//     value: "http://localhost:18002/signtask",
//     label: "signtask"
//   }
// ];

export {requestURLs};
