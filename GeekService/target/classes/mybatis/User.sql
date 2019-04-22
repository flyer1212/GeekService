create table user(u_id VARCHAR (100),
                  name VARCHAR (20),
                  password VARCHAR (20),
                  sex int(1),
                  major VARCHAR (20),
                  idCard VARCHAR (20),
                  mobilePhone VARCHAR (20),
                  wechat VARCHAR (20),
                  qqNumber VARCHAR (20),
                  registerTime DATE ,
                  lastLoginTime DATE ,
                  PRIMARY KEY(u_id)
                  );