# JavaSE Learning

这是abigmelon的 JavaSE 学习仓库，用来记录 Java 基础语法、面向对象、常用 API 以及相关练习代码。

## 当前学习重点

- Java 基础语法
- 包与目录结构
- 类与对象
- 字段与方法
- 对象引用与方法传参

## 目录结构

- `src/`：Java 源码目录
- `src/cn/abigmelon/`：主程序与学习示例
- `src/cn/abigmelon/entity/`：实体类、对象相关练习
- `notes/weekly/`：Codex 自动生成的每周学习复盘
- `.learning-snapshot/`：Codex 自动化使用的本地对比快照，不需要提交到 GitHub
- `out/`：本地编译输出目录，不需要提交到 GitHub

## Codex 自动化

本仓库在本地配置了一个 Codex 自动化任务：`JavaSE 每周学习复盘`。

自动化会在每天晚上 22:00 左右检查本仓库的学习变化，并将当天内容整理到本周的 Markdown 文档中。

周报保存位置：

```text
notes/weekly/YYYY-Www.md
```

例如：

```text
notes/weekly/2026-W25.md
```

每份周报会按日期累计 7 天内容，主要包括：

- 今日文件变化
- 今日学习内容
- 关键代码理解
- 易错点与待修正
- 明天建议
- 本周待巩固内容

自动化会优先使用 `.learning-snapshot/latest/` 中的昨日快照作为对比基准；如果没有快照，则使用 Git 当前记录作为首次基准。

## 版本管理说明

本仓库会同步到 GitHub，但以下内容只保留在本地：

- IDE 配置
- 编译产物
- Codex 自动化快照

主要提交内容应包括：

- `src/` 下的 Java 源码
- `README.md`
- `notes/weekly/` 下的学习复盘

## 备注

学习过程中需要注意包名和目录路径保持一致，例如 `package cn.abigmelon;` 对应的文件应放在 `src/cn/abigmelon/` 下。
