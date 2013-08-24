activiti-jpa-spring-transaction-demo
====================================

This is a very small programm (only one hundred strokes of code) I illustrate that Activiti can't correctly use the same transaction manager as an Hibernate. 
If you put your entity into Activiti's execution context, and then rollback transaction it will be stored into next tables:
1. ACT_GE_BYTEARRAY
2. ACT_HI_DETAIL
3. ACT_HI_VARINST
4. ACT_RU_VARABLE
