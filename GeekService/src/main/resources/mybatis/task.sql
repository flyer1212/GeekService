create table task(task_id VARCHAR (100),
                  u_id VARCHAR (100),
                  taskTitle VARCHAR (20),
                  taskType VARCHAR (20),
                  taskRequire VARCHAR (20),
                  taskDescribe VARCHAR (20),
                  reward int(1),
                  taskState int(1),
                  taskEndTime DATE ,
                  taskSubmitTime DATE ,
                  PRIMARY KEY(task_id)
                  );