---
title: 成功页
---
<template>
  <my-wrapper fit>
    <my-container>
      <my-result status="success"
                 title="提交成功"
                 subtitle="提交结果页用于反馈一系列操作任务的处理结果， 如果仅是简单操作，使用 Message 全局提示反馈即可。 本文字区域可以展示简单的补充说明，如果有类似展示 “单据”的需求，下面这个灰色区域可以呈现比较复杂的内容。">
       <my-title :level="4">项目名称</my-title>
        <el-steps :active="2" align-center>
          <el-step title="步骤1" description="这是一段很长很长很长的描述性文字"></el-step>
          <el-step title="步骤2" description="这是一段很长很长很长的描述性文字"></el-step>
          <el-step title="步骤3" description="这是一段很长很长很长的描述性文字"></el-step>
          <el-step title="步骤4" description="这是一段很长很长很长的描述性文字"></el-step>
        </el-steps>
        <template v-slot:extra>
          <el-button type="primary">返回列表</el-button>
          <el-button>查看项目</el-button>
        </template>
      </my-result>
    </my-container>
  </my-wrapper>
</template>

<script>
  export default {}
</script>
