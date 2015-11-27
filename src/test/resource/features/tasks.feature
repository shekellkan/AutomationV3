@tasks
  Feature:Tasks
    create task, delete task, complete task

    Background:
      Given I navigate to login page of Trello.com
        And I login in Trello.com as "miguel.terceros@fundacion-jala.org" with password "morfeo3730"

    Scenario: create task into user storie
      Given I go to create Project page "Project_Board_UserStorie_Task"
        And I create a board "BackLog"
        And I create a User Stories "User_Storie_Task" into board "BackLog"
        And I navigate to User Storie "User_Storie_Task" page
      When I create a task "task_1" into user storie "User_Storie_Task"
        Then The task "task_1" is added into the user storie "User_Storie_Task"

    Scenario: create task, add comment, add deadline
      Given I go to create Project page "Project_UserStorie_Personalized"
        And I create a board "BackLog"
        And I create a User Stories "User_Storie_Task" into board "BackLog"
        And I navigate to User Storie "User_Storie_Task" page
      When I create a task "task_1" into user storie "User_Storie_Task"
        And I add a comment "this a comment for the user storie" into the user storie
        And I add deadline for the user storie
        Then The user storie "User_Storie_Task" have a task "task_1"
        And The user storie "User_Storie_Task" have a comment "this a comment for the user storie"
        And The user storie "User_Storie_Task" have a deadline