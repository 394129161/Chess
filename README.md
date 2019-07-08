# Chess

单机人人对战的五子棋游戏，目标是实现可联机、可人机、多棋类的下棋游戏

## 环境依赖

- Java1.8

## 运行方法

- 调用Demo.java

## 目录结构

    src
    ├─main
    │  └─project
    │      │  Base.java
    │      │  Demo.java
    │      │  
    │      ├─controller
    │      │      HumanPlayer.java
    │      │      Online.java
    │      │      OnlinePlayer.java
    │      │      Player.java
    │      │      Robot.java
    │      │      
    │      ├─DTO
    │      │      DropPoint.java
    │      │      
    │      ├─five                       //五子棋相关
    │      │  ├─controller
    │      │  │      HumanPlayer.java
    │      │  │      
    │      │  ├─DTO
    │      │  │      DropPoint.java
    │      │  │      
    │      │  ├─model
    │      │  │      Situation.java
    │      │  │      
    │      │  ├─resource
    │      │  │      bg.jpg
    │      │  │      blackchess.GIF
    │      │  │      whitechess.GIF
    │      │  │      
    │      │  ├─service
    │      │  │      Referee.java
    │      │  │      
    │      │  ├─utils
    │      │  │      Tools.java
    │      │  │      
    │      │  └─view
    │      │          ChessResource.java
    │      │          Desktop.java
    │      │          
    │      ├─gui
    │      │      Gui.java
    │      │      
    │      ├─model
    │      │      Situation.java
    │      │      
    │      ├─service
    │      │      Referee.java
    │      │      
    │      └─view
    │              Desktop.java
    │              
    └─test

## V1.0

### 内容更新

- 实现了粗糙的测试用GUI
- 仅支持人人对战
- 暂时只实现了五子棋一类棋种

### 下一步计划

- 实现能适配多棋种、可提供用户功能、加强交互能力的GUI
- 调整抽象层次，提高抽象层的可利用能力
- 调整目录结构，提高分包的科学性

### 作者记

#### Ponecrazy

- 两个月前就计划要做，趁着放假花了两三天写了这样一个东西，勉强能出来一个框架，但是目前还是施工现场，需要调整修改和补充的地方还有很多

- 作为Java基础学习第一个独立练手的小项目，也是第一次正式应用GitHub，一切都在摸索和学习，希望能在此记录自己的成长
