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

const requestURLs = [
  {
    value: "http://10.141.211.161:18002/task",
    label: "请求所有的task"
  },
  {
    value: "http://10.141.211.161:18002/task/task/",
    label: "taskdetail"
  },
  {
    value: "http://10.141.211.161:18000/auth/login",
    label: "login"
  },
  {
    value: "http://10.141.211.161:18001/user/register",
    label: "register"
  },
  {
    value: "http://10.141.211.161:18002/signtask",
    label: "signtask"
  }
];

//   const requestURLs2 =  [
//     {
//       value: "http://geek-task-service:18002/task",
//       label: "请求所有的task"
//     },
//     {
//       value: "http://geek-task-service:18002/task/task/",
//       label: "taskdetail"
//     },
//     {
//       value: "http://geek-auth-service:18000/auth/login",
//       label: "login"
//     },
//     {
//       value: "http://geek-user-service:18001/user/register",
//       label: "register"
//     }
//   ];

export { requestURLs };
