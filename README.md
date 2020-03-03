# offerLearning
#git简单操作学习
本地新建分支              git branch develop
提交本地新建分支到远端    git pull origin develop
切换到该分支              git checkout develop
查看本地修改              git status
添加本地修改              git add .    此时只是在暂存区
commit修改                git commit -m 'XXXX'
push代码                  git push origin develop
查看分支                  git branch
切换到主分支              git checkout master
拉取代码                  git pull
合并到主分支              git merge master
push到主分支              git push
将本地分支develop与远端映射      git branch --set-upstream-to origin/develop
合并分支develop到当前分支        git merge origin develop

 git 常见问题：
 问：执行git push出现"Everything up-to-date"
 答：没有执行git add .   和 git commit -m 'XXXX'
     如果两个命令都执行，那么就是创建的目录是空的，目录下必须有文件才能git push成功
 问：merge到master分支后如何回滚
 答：先查看merge操作的上一个提交记录的版本号  git reflog
     找到“moving from develop to master”这条记录的版本号
     git reset --hard 版本号   就可以回滚到merge之前的状态
  