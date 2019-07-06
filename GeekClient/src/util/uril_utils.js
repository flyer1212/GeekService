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


  //
  // const requestURLs =  [
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
  //   value: "http://localhost:18002/signtask",
  //   label: "signtask"
  //  }
  // ];

// k8s and docker-compose
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
  }
];
// docker-compose 外部
// const requestURLs = [
//   {
//     value: "http://10.141.211.161:30002/task",
//     label: "请求所有的task"
//   },
//   {
//     value: "http://10.141.211.161:30002/task/task/",
//     label: "taskdetail"
//   },
//   {
//     value: "http://10.141.211.161:30000/auth/login",
//     label: "login"
//   },
//   {
//     value: "http://10.141.211.161:30001/user/register",
//     label: "register"
//   },
//   {
//     value: "http://10.141.211.161:30002/signtask",
//     label: "signtask"
//   }
// ];

export { requestURLs };
