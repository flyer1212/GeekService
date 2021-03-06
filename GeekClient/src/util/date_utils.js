const sumbitTime = function(submitDate) {
  var submitDay = new Date(submitDate);
  // 2014-06-05  计算发布到现在的时间差
  var times =
    submitDay.getFullYear() +
    "-" +
    (submitDay.getMonth() + 1) +
    "-" +
    submitDay.getDate() +
    " " +
    submitDay.getHours() +
    ":" +
    submitDay.getMinutes() +
    ":" +
    submitDay.getSeconds();
  var nowTime = Date.parse(new Date());
  var submitTime = Date.parse(times);
  var day = parseInt((nowTime - submitTime) / (1000 * 60 * 60 * 24));
  var hours = parseInt((nowTime - submitTime) / (1000 * 60 * 60));
  var minutes = parseInt((nowTime - submitTime) / (1000 * 60));
  console.log(day + "-" + hours + "-" + minutes);
  if (day > 0) {
    return day + "天前";
  } else if (day < 1 && hours > 0) {
    return hours + "小时前";
  } else {
    return minutes + "分钟前";
  }
};

const calculateEndDay = function(endDate) {
  var endDay = new Date(endDate);
  var endTimes =
    endDay.getFullYear() +
    "-" +
    (endDay.getMonth() + 1) +
    "-" +
    endDay.getDate() +
    " " +
    endDay.getHours() +
    ":" +
    endDay.getMinutes() +
    ":" +
    endDay.getSeconds();
  var nowTime = Date.parse(new Date());
  var endTimes = Date.parse(endTimes);
  var day = parseInt((endTimes - nowTime) / (1000 * 60 * 60 * 24));
  var hours = parseInt((endTimes - nowTime) / (1000 * 60 * 60));
  var minutes = parseInt((endTimes - nowTime) / (1000 * 60));
  console.log(day + "-" + hours + "-" + minutes);
  if (day > 0) {
    return day + "天之内";
  } else if (day < 1 && hours > 0) {
    return hours + "小时内";
  } else {
    return minutes + "分钟内";
  }
};


const timestamp2Time =  function(timestamp) {
  var date = new Date(timestamp * 1000);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
  // Y = date.getFullYear() + '-';
  // M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
  // D = date.getDate() + ' ';
  var h = date.getHours() + ':';
  var m = date.getMinutes() + ':';
  var s = date.getSeconds();
  return  h+m+s;
}

const hello = function(){
  console.log("hello !")
}

export {sumbitTime, calculateEndDay,timestamp2Time, hello}