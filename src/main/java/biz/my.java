package biz;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : 1766318593@qq.com
 * @Creation Date : 2018年09月06日下午5:45
 * @Function : todo
 */
public class my {

//          if (CollectionUtils.isEmpty(questionFieldsDTOList)){
//        return ;
//    }
    List<Long> businessIdList = Lists.newArrayList();
    List<Long> orderTypeIdList = Lists.newArrayList();
    List<Long> questionTypeIdList = Lists.newArrayList();
    List<Long> fourthCategoryIdList = Lists.newArrayList();
    List<Long> fifthCategoryIdList = Lists.newArrayList();
    List<Long> questionIdList = Lists.newArrayList();

////        // 倒着匹配
//        for (QuestionFieldsDTO  questionFieldsDTO : questionFieldsDTOList){
////            if (questionFieldsDTO.getQuestionId() != null){
////                questionIdList.add(questionFieldsDTO.getQuestionId());
////            }else if (questionFieldsDTO.getFifthCategoryId() != null){
////                fifthCategoryIdList.add(questionFieldsDTO.getFifthCategoryId());
////            }else if (questionFieldsDTO.getFourthCategoryId() != null){
////                fourthCategoryIdList.add(questionFieldsDTO.getFourthCategoryId());
////            }else if (questionFieldsDTO.getQuestionTypeId() != null){
////                questionTypeIdList.add(questionFieldsDTO.getQuestionTypeId());
////            }else if (questionFieldsDTO.getOrderTypeId() != null){
////                orderTypeIdList.add(questionFieldsDTO.getOrderTypeId());
////            }else if (questionFieldsDTO.getBusinessId() != null){
////                businessIdList.add(questionFieldsDTO.getBusinessId());
////            }
//            if (questionFieldsDTO.getQuestionId() != null){
//                questionIdList.add(questionFieldsDTO.getQuestionId());
//            }
//            if (questionFieldsDTO.getFifthCategoryId() != null){
//                fifthCategoryIdList.add(questionFieldsDTO.getFifthCategoryId());
//            }
//            if (questionFieldsDTO.getFourthCategoryId() != null){
//                fourthCategoryIdList.add(questionFieldsDTO.getFourthCategoryId());
//            }
//            if (questionFieldsDTO.getQuestionTypeId() != null){
//                questionTypeIdList.add(questionFieldsDTO.getQuestionTypeId());
//            }
//            if (questionFieldsDTO.getOrderTypeId() != null){
//                orderTypeIdList.add(questionFieldsDTO.getOrderTypeId());
//            }
//            if (questionFieldsDTO.getBusinessId() != null){
//                businessIdList.add(questionFieldsDTO.getBusinessId());
//            }
//
//        }
//
//        if (CollectionUtils.isNotEmpty(businessIdList)) {
//            queryBuilder.should(QueryBuilders.termsQuery(CaseDbEsRelEnum.FIRST_CATEGORY_ID.getEsName(), businessIdList));
//        }
//        if (CollectionUtils.isNotEmpty(orderTypeIdList)){
//            queryBuilder.should(QueryBuilders.termsQuery(CaseDbEsRelEnum.SECOND_CATEGORY_ID.getEsName(),orderTypeIdList));
//        }
//        if (CollectionUtils.isNotEmpty(questionTypeIdList)) {
//            queryBuilder.should(QueryBuilders.termsQuery(CaseDbEsRelEnum.THIRD_CATEGORY_ID.getEsName(), questionTypeIdList));
//        }
//        if (CollectionUtils.isNotEmpty(fourthCategoryIdList)) {
//            queryBuilder.should(QueryBuilders.termsQuery(CaseDbEsRelEnum.FOURTH_CATEGORY_ID.getEsName(), fourthCategoryIdList));
//        }
//        if (CollectionUtils.isNotEmpty(fifthCategoryIdList)) {
//            queryBuilder.should(QueryBuilders.termsQuery(CaseDbEsRelEnum.FIFTH_CATEGORY_ID.getEsName(), fifthCategoryIdList));
//        }
//        if (CollectionUtils.isNotEmpty(questionIdList)) {
//            queryBuilder.should(QueryBuilders.termsQuery(CaseDbEsRelEnum.QUESTION_ID.getEsName(), questionIdList));
//        }
    // queryBuilder.minimumShouldMatch(1);



    //            if (inputVO.getLevel() != null && inputVO.getDepartmentId() != null && inputVO.getDepartmentId() != 1){ // 部门
//                queryBuilder.mustNot(getMissingFilters(CaseDbEsRelEnum.OWNER_ID.getEsName()));
//                queryBuilder.must(QueryBuilders.termQuery("level_"+(inputVO.getLevel()+1L),inputVO.getDepartmentId()));
//            } else if (inputVO.getLevel() != null && inputVO.getDepartmentId() != null && inputVO.getDepartmentId() == 1) { // 其他员工
//                queryBuilder.mustNot(getMissingFilters(CaseDbEsRelEnum.OWNER_ID.getEsName()));
//                queryBuilder.must(QueryBuilders.termQuery(CaseDbEsRelEnum.DEPARTMENT_ID.getEsName(), inputVO.getDepartmentId()));
//            } else if (inputVO.getLeftTypeId() != null){ // 总量 未分配 已经分配
//                queryBuilder.must(LeftMonitorTypeParser(inputVO.getLeftTypeId()));
//            }else if (inputVO.getStaffId() != null){ // 底部了 查找个员工
//                queryBuilder.must(QueryBuilders.termQuery(CaseDbEsRelEnum.OWNER_ID.getEsName(),inputVO.getStaffId()));
//            } else{
//                queryBuilder.must(QueryBuilders.matchAllQuery());
//            }

}
