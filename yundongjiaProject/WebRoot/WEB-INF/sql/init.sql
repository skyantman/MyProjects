drop table if exists base_attach;

drop table if exists base_auth;

drop table if exists base_brand;

drop table if exists base_card_member_ref;

drop table if exists base_class;

drop table if exists base_class_info;

drop table if exists base_class_order;

drop table if exists base_class_plan;

drop table if exists base_coach;

drop table if exists base_dict;

drop table if exists base_leave;

drop table if exists base_mcard;

drop table if exists base_mcard_spec;

drop table if exists base_member;

drop table if exists base_member_card_type;

drop table if exists base_menu;

drop table if exists base_menu_user_ref;

drop table if exists base_opeartion;

drop table if exists base_plan_action;

drop table if exists base_recharge;

drop table if exists base_sign;

drop table if exists base_space;

drop table if exists base_studio;

drop table if exists base_user;

drop table if exists base_user_auth_ref;

/*==============================================================*/
/* Table: base_attach                                           */
/*==============================================================*/
create table base_attach
(
   attach_id            int(11) not null auto_increment comment '主键',
   attach_path          varchar(200) not null comment '路径',
   attach_old_name      varchar(200) comment '原文件名',
   attach_type          tinyint(3) not null default 1 comment '保留',
   attach_create_date   datetime not null comment '创建时间',
   attach_stat          tinyint(3) comment '目前保留,以便以后逻辑删除修改使用',
   primary key (attach_id)
);

alter table base_attach comment '系统所有附件信息的表';

/*==============================================================*/
/* Table: base_auth                                             */
/*==============================================================*/
create table base_auth
(
   auth_id              int(11) not null auto_increment comment '主键',
   auth_opname          varchar(100) not null comment '操作名',
   auth_comm            varchar(200) comment '说明',
   auth_create_date     datetime not null comment '创建日期',
   auth_operatorid      int(11) comment '操作人',
   primary key (auth_id)
);

/*==============================================================*/
/* Table: base_brand                                            */
/*==============================================================*/
create table base_brand
(
   brand_id             int(11) not null comment '品牌id',
   brand_user_id        int(11) comment '品牌管理员',
   brand_name           varchar(100) not null comment '品牌名',
   brand_create_date    datetime not null comment '创建日期',
   brand_imgpath        varchar(200) comment '图片地址',
   brand_type           tinyint(3) comment '保留',
   brand_statu          tinyint(3) comment '保留',
   primary key (brand_id)
);

alter table base_brand comment '品牌信息表';

/*==============================================================*/
/* Table: base_card_member_ref                                  */
/*==============================================================*/
create table base_card_member_ref
(
   card_member_id       int(11) not null auto_increment comment '关联id',
   card_member_card_id  int(11) comment '卡id',
   card_member_member_id int(11) comment '会员id',
   card_member_create_date datetime not null comment '创建时间',
   primary key (card_member_id)
);

/*==============================================================*/
/* Table: base_class                                            */
/*==============================================================*/
create table base_class
(
   class_id             int(11) not null auto_increment comment '课id',
   class_coach_id       int(11) comment '教练id',
   class_type           tinyint(3) not null comment '1:团课  2:私教课',
   class_maxnum         int(5) comment '可约人数',
   class_startdate      date comment '开始日期',
   class_enddate        date comment '结束日期',
   class_days           varchar(100) comment '周期日期',
   class_starttime      time comment '开始时间',
   class_endtime        time comment '结束时间',
   class_statu          tinyint(3) comment '状态',
   class_card_type      tinyint(3) comment '会员卡类型',
   class_operatorid     int(11) comment '操作人',
   class_pay_type       tinyint(3) not null comment '消费类型支持    1:几次  2:储值  4:期限',
   class_pay_count      tinyint(3) comment '计次数量',
   class_pay_store      int(5) comment '储值消费金额',
   primary key (class_id)
);

alter table base_class comment '工作室的课信息';

/*==============================================================*/
/* Table: base_class_info                                       */
/*==============================================================*/
create table base_class_info
(
   class_info_id        int(11) not null auto_increment comment '课程id',
   class_info_plan_id   int(11) comment '计划id',
   class_info_studio_id int(11) not null comment '场馆id',
   class_info_classname varchar(200) not null comment '名称',
   class_info_duration  int(5) not null comment '时长',
   class_info_maxnum    int(5) comment '可约人数',
   class_info_minnum    int(5) comment '最少人数',
   class_info_introduce varchar(500) comment '简介',
   class_info_type      tinyint(3) not null comment '1:团课    2:私教课',
   class_info_statu     tinyint(3) comment '状态',
   class_info_operatorid int(11) comment '操作人',
   class_info_imgpath   varchar(200) comment '图片店址',
   primary key (class_info_id)
);

alter table base_class_info comment '课程信息,包括私教课和团课';

/*==============================================================*/
/* Table: base_class_order                                      */
/*==============================================================*/
create table base_class_order
(
   class_order_id       int(11) not null auto_increment comment '预约id',
   class_order_class_id int(11) not null comment '课id',
   class_order_member_id int(11) not null comment '预约会员id',
   class_order_date     date not null comment '日期',
   class_order_starttime time not null comment '开始时间',
   class_order_endtime  time not null comment '结束时间',
   class_order_statu    tinyint(3) comment '保留',
   primary key (class_order_id)
);

alter table base_class_order comment '预约课程信息';

/*==============================================================*/
/* Table: base_class_plan                                       */
/*==============================================================*/
create table base_class_plan
(
   class_plan_id        int(11) not null auto_increment comment '计划id',
   class_plan_studio_id int(11) not null comment '所属场馆id',
   class_plan_name      varchar(100) not null comment '计划名称',
   class_plan_type      tinyint(3) not null comment '计划类型',
   class_plan_createdate datetime not null comment '创建时间',
   class_plan_statu     tinyint(3) comment '状态',
   class_plan_operatorid int(11) comment '操作人',
   primary key (class_plan_id)
);

alter table base_class_plan comment '课程计划信息';

/*==============================================================*/
/* Table: base_coach                                            */
/*==============================================================*/
create table base_coach
(
   coach_id             int(11) not null auto_increment comment '教练id',
   coach_studio_id      int(11) comment '所属工作室id',
   coach_nickname       varchar(100) not null comment '教练姓名',
   coach_gender         tinyint(3) not null comment '性别',
   coach_phoneno        varchar(100) not null comment '手机号',
   coach_remarks        varchar(500) comment '备注',
   coach_statu          tinyint(3) not null comment '状态',
   coach_operatorid     int(11) comment '创建人',
   coach_imgpath        varchar(200) comment '头像地址',
   primary key (coach_id)
);

alter table base_coach comment '教练信息表';

/*==============================================================*/
/* Table: base_dict                                             */
/*==============================================================*/
create table base_dict
(
   dict_id              int(11) not null auto_increment comment '主键',
   dict_key             varchar(200) not null comment '名字',
   dict_valu            varchar(500) not null comment '值',
   dict_type            tinyint(3) not null comment '1:系统配置     暂定',
   dict_isshow          tinyint(3) not null comment '1:启用   0:不启用',
   dict_create_date     datetime not null comment '创建时间',
   dict_comm            varchar(200) comment '说明',
   primary key (dict_id)
);

alter table base_dict comment '系统字典信息表';

/*==============================================================*/
/* Table: base_leave                                            */
/*==============================================================*/
create table base_leave
(
   leave_id             int(11) not null auto_increment comment '请假id',
   leave_mcard_id       int(11) comment '卡id',
   leave_reason         varchar(500) not null comment '请假事由',
   leave_startdate      date not null comment '开始日期',
   leave_enddate        date not null comment '结束日期',
   leave_charge         int(10) comment '收费',
   leave_remarks        varchar(200) comment '备注',
   leave_createdate     datetime comment '创建日期',
   primary key (leave_id)
);

alter table base_leave comment '请假记录';

/*==============================================================*/
/* Table: base_mcard                                            */
/*==============================================================*/
create table base_mcard
(
   mcard_id             int(11) not null auto_increment comment '卡id',
   mcard_spec_id        int(11) not null comment '规格id',
   mcard_spec_type_id   int(11) not null comment '种类id',
   mcard_have_startdate tinyint(3) not null comment '1:有开始时间   0:没有',
   mcard_date_limit     tinyint(3) not null comment '1:有期限   0:没期限',
   mcard_autostart      tinyint(3) not null comment '自动开卡  1:是  0:不是',
   mcard_card_balance   int(11) not null comment '余额',
   mcard_cardnum        varchar(100) not null comment '卡号',
   mcard_from           tinyint(3) not null comment '来源',
   mcard_statu          tinyint(3) not null comment '1:正常 2:请假 3:停用',
   mcard_isdel          tinyint(3) not null comment '是否删除 1:删除   0:没有',
   mcard_startdate      datetime comment '开始日期',
   mcard_enddate        datetime comment '到期日期',
   mcard_comm           varchar(200) comment '备注',
   mcard_operatorid     int(11) comment '操作人',
   mcard_card_createdate datetime not null comment '办理日期',
   primary key (mcard_id)
);

alter table base_mcard comment '会员卡信息';

/*==============================================================*/
/* Table: base_mcard_spec                                       */
/*==============================================================*/
create table base_mcard_spec
(
   mcard_spec_id        int(11) not null auto_increment comment '规格id',
   mcard_spec_type_id   int(11) not null comment '种类id',
   mcard_spec_balance   int(11) not null comment '余额',
   mcard_spec_realmoney int(11) not null comment '实冲金额',
   mcard_spec_create_date datetime not null comment '添加时间',
   mcard_spec_have_validity tinyint(3) not null comment '是否拥有有效期  1:有    0:没有',
   mcard_spec_comm      varchar(200) comment '说明',
   mcard_spec_operatorid int(11) comment '操作人',
   mcard_spec_validity_days int(5) comment '有效期 ',
   primary key (mcard_spec_id)
);

alter table base_mcard_spec comment '会员卡种类下面的具体规格';

/*==============================================================*/
/* Table: base_member                                           */
/*==============================================================*/
create table base_member
(
   member_id            int(11) not null auto_increment comment '主键',
   member_studio_id     int(11) not null comment '所属工作室',
   member_user_id       int(11) not null comment '办理人员',
   member_nickname      varchar(100) not null comment '姓名',
   member_gender        tinyint(3) not null comment '0:男   1:女',
   member_mobilephoneno varchar(100) not null comment '手机号',
   member_isdel         tinyint(3) not null comment '是否删除  1:删除   0:没有',
   member_address       varchar(500) comment '地址',
   member_remarks       varchar(500) comment '备注',
   member_create_date   datetime not null comment '创建日期',
   member_statu         tinyint(3) comment '保留',
   member_operatorid    int(11) comment '创建人',
   primary key (member_id)
);

/*==============================================================*/
/* Table: base_member_card_type                                 */
/*==============================================================*/
create table base_member_card_type
(
   member_card_type_id  int(11) not null auto_increment comment '种类id',
   member_card_type_studio_id int(11) comment '适用场馆',
   member_card_type_name varchar(100) not null comment '名称',
   member_card_type_type tinyint(3) not null comment '1:计次  2:储值  3:期限',
   member_card_type_islimit tinyint(3) not null comment '是否限制条件',
   member_card_type_introduce varchar(200) comment '简介',
   member_card_type_appointmentnum int(5) comment '预约课程数',
   member_card_type_classnum int(5) comment '可上课数',
   member_card_type_buy_limit_num int(5) comment '限购数量',
   member_card_type_create_date date not null comment '创建日期',
   member_card_type_operatorid int(11) comment '操作人',
   primary key (member_card_type_id)
);

alter table base_member_card_type comment '会员卡种类信息表';

/*==============================================================*/
/* Table: base_menu                                             */
/*==============================================================*/
create table base_menu
(
   menu_id              int(11) not null auto_increment comment '主键',
   menu_pid             int(11) not null comment '父节点id',
   menu_name            varchar(100) not null comment '菜单名',
   menu_ordernum        int(5) comment '数字越大越靠前',
   menu_isshow          tinyint(3) not null default 1 comment '1:展示  0:不展示',
   menu_pathname        varchar(200) comment '接口名',
   menu_isroot          tinyint(3) not null comment '1:是根   0:不是根',
   menu_isdel           tinyint(3) not null comment '1:被删除   0:没有被删除',
   menu_powerid         varchar(100) comment '权限标识',
   primary key (menu_id)
);

alter table base_menu comment '健身房管理系统菜单表';

/*==============================================================*/
/* Table: base_menu_user_ref                                    */
/*==============================================================*/
create table base_menu_user_ref
(
   menu_user_id         int(11) not null auto_increment comment '主键',
   menu_user_menu_id    int(11) not null comment '菜单id',
   menu_user_user_id    int(11) not null comment '用户id',
   menu_user_type       tinyint(3) comment '保留',
   menu_user_create_date datetime not null comment '创建日期',
   menu_user_operatorid int(11) comment '操作人',
   primary key (menu_user_id)
);

alter table base_menu_user_ref comment '用户菜单关系对应表';

/*==============================================================*/
/* Table: base_opeartion                                        */
/*==============================================================*/
create table base_opeartion
(
   opeartion_id         int(11) not null auto_increment comment '操作id',
   opeartion_createdate datetime not null comment '操作时间',
   opeartion_opuser_id  int(11) not null comment '操作人id',
   opeartion_type       varchar(100) not null comment '操作类型',
   opeartion_comm       varchar(200) not null comment '操作内容',
   opeartion_obj_type   tinyint(3) not null comment '被操作对象类型   1:member   2:user',
   opeartion_beuser_id  int(11) comment '被操作的userid',
   opeartion_bemember_id int(11) comment '被操作的memberid',
   primary key (opeartion_id)
);

alter table base_opeartion comment '操作记录';

/*==============================================================*/
/* Table: base_plan_action                                      */
/*==============================================================*/
create table base_plan_action
(
   plan_action_id       int(11) not null comment '动作id',
   plan_action_plan_id  int(11) not null comment '计划id',
   plan_action_name     varchar(100) not null comment '动作名称',
   plan_action_equipment varchar(200) comment '器械',
   plan_action_type     tinyint(3) not null comment '计量方式',
   plan_action_times    int(5) comment '次数',
   plan_action_grps     int(5) comment '组数',
   plan_action_statu    tinyint(3) comment '状态',
   primary key (plan_action_id)
);

alter table base_plan_action comment '课程计划动作信息';

/*==============================================================*/
/* Table: base_recharge                                         */
/*==============================================================*/
create table base_recharge
(
   recharge_id          int(11) not null auto_increment comment '充值id',
   recharge_mcard_id    int(11) not null comment '卡id',
   recharge_user_id     int(11) not null comment '充值人',
   recharge_spec_id     int(11) not null comment '规格id',
   recharge_real_money  int(10) not null comment '实收金额',
   recharge_pay_type    tinyint(3) not null comment '充值方式',
   recharge_type        tinyint(3) not null comment '1:充值   2:消费',
   recharge_date_limit  tinyint(3) not null comment '1:有期限   0:无期限',
   recharge_createdate  datetime not null comment '发生时间',
   recharge_remarks     varchar(200) comment '备注',
   recharge_startdate   datetime comment '开始日期',
   recharge_enddate     datetime comment '结束日期',
   recharge_desc        varchar(200) comment '描述',
   primary key (recharge_id)
);

alter table base_recharge comment '会员卡消费/充值记录信息';

/*==============================================================*/
/* Table: base_sign                                             */
/*==============================================================*/
create table base_sign
(
   sign_id              int(11) not null auto_increment comment '签到id',
   sign_studio_id       int(11) not null comment '工作室id',
   sign_member_id       int(11) not null comment '主键',
   sign_time            datetime not null comment '签到时间',
   sign_type            int(5) comment '保留',
   primary key (sign_id)
);

alter table base_sign comment '签到记录';

/*==============================================================*/
/* Table: base_space                                            */
/*==============================================================*/
create table base_space
(
   space_id             int(11) not null auto_increment comment '场地id',
   space_studio_id      int(11) not null comment '所属场馆',
   space_maxpnum        tinyint(3) not null comment '容纳人数',
   space_applyclass     tinyint(3) not null comment '适用课程',
   space_create_date    datetime not null comment '创建日期',
   space_statu          tinyint(3) not null default 0 comment '0:关闭   1:开启',
   space_operatorid     int(11) comment '创建人id',
   primary key (space_id)
);

alter table base_space comment '工作室场地信息';

/*==============================================================*/
/* Table: base_studio                                           */
/*==============================================================*/
create table base_studio
(
   studio_id            int(11) not null auto_increment comment '工作室id',
   studio_brand_id      int(11) not null comment '品牌id',
   studio_name          varchar(200) not null comment '场馆名',
   studio_phoneno       varchar(100) not null comment '电话',
   studio_isdel         tinyint(3) not null comment '是否删除 1:删除  0:没有',
   studio_address       varchar(500) comment '场馆地址',
   studio_wechatno      varchar(500) comment '微信号',
   studio_statu         tinyint(3) comment '保留',
   studio_mail          varchar(200) comment '邮箱',
   studio_mon           varchar(100) comment '星期一',
   studio_tues          varchar(100) comment '星期二',
   studio_wed           varchar(100) comment '星期三',
   studio_thur          varchar(100) comment '星期四',
   studio_fri           varchar(100) comment '星期五',
   studio_sat           varchar(100) comment '星期六',
   studio_sun           varchar(100) comment '星期日',
   studio_imgpath       varchar(200) comment '图片地址',
   studio_sign_rule     varchar(100) comment '签到规则(json)',
   primary key (studio_id)
);

/*==============================================================*/
/* Table: base_user                                             */
/*==============================================================*/
create table base_user
(
   user_id              int(11) not null auto_increment comment '主键',
   user_studio_id       int(11) comment '所属工作室',
   user_brand_id        int(11) comment '品牌id',
   user_mobilephoneno   varchar(100) not null comment '手机号',
   user_create_date     datetime not null comment '创建日期',
   user_status          tinyint(3) not null default 2 comment '0:禁用  1:启用  2:未授权',
   user_type            tinyint(3) not null comment '0:系统管理员  1:总控工作人员   2:品牌管理员   3:场馆工作人员',
   user_password        varchar(200) comment '密码',
   user_name            varchar(100) comment '用户名字',
   user_gender          char(10) comment '0:男  1:女',
   user_operatorid      int(11) comment '操作人',
   user_comm            varchar(200) comment '备注',
   user_password_error_times tinyint(3) comment '密码错误次数',
   user_last_login_time datetime comment '最后登录时间',
   user_last_login_ip   varchar(50) comment '最后登录ip',
   user_isdel           tinyint(3) not null comment '1:被删除   0: 没被删除',
   user_role_tag        varchar(100) not null comment '角色标签,对应字典表',
   primary key (user_id)
);

alter table base_user comment '登录用户表';

/*==============================================================*/
/* Table: base_user_auth_ref                                    */
/*==============================================================*/
create table base_user_auth_ref
(
   user_auth_id         int not null auto_increment comment '主键',
   user_auth_auth_id    int(11) not null comment '权限id',
   user_auth_user_id    int(11) not null comment '指定的用户',
   user_auth_create_date datetime not null comment '创建日期',
   user_auth_operatorid int(11) comment '操作人',
   primary key (user_auth_id)
);

alter table base_user_auth_ref comment '用户和操作权限对应表';

alter table base_brand add constraint FK_Reference_25 foreign key (brand_user_id)
      references base_user (user_id) on delete restrict on update restrict;

alter table base_card_member_ref add constraint FK_Reference_26 foreign key (card_member_card_id)
      references base_mcard (mcard_id) on delete cascade;

alter table base_card_member_ref add constraint FK_Reference_27 foreign key (card_member_member_id)
      references base_member (member_id) on delete cascade;

alter table base_class add constraint FK_Reference_37 foreign key (class_id)
      references base_class_info (class_info_id) on delete restrict on update restrict;

alter table base_class add constraint FK_Reference_38 foreign key (class_coach_id)
      references base_coach (coach_id) on delete set null on update cascade;

alter table base_class_info add constraint FK_Reference_34 foreign key (class_info_plan_id)
      references base_class_plan (class_plan_id) on delete set null on update cascade;

alter table base_class_info add constraint FK_Reference_35 foreign key (class_info_studio_id)
      references base_studio (studio_id) on delete cascade on update cascade;

alter table base_class_order add constraint FK_Reference_33 foreign key (class_order_member_id)
      references base_member (member_id) on delete cascade on update cascade;

alter table base_class_order add constraint FK_Reference_42 foreign key (class_order_class_id)
      references base_class (class_id) on delete cascade on update cascade;

alter table base_class_plan add constraint FK_Reference_31 foreign key (class_plan_studio_id)
      references base_studio (studio_id) on delete cascade on update cascade;

alter table base_coach add constraint FK_Reference_18 foreign key (coach_studio_id)
      references base_studio (studio_id) on delete set null;

alter table base_leave add constraint FK_Reference_46 foreign key (leave_mcard_id)
      references base_mcard (mcard_id) on delete cascade on update cascade;

alter table base_mcard add constraint FK_Reference_24 foreign key (mcard_spec_id)
      references base_mcard_spec (mcard_spec_id) on delete cascade;

alter table base_mcard add constraint FK_Reference_39 foreign key (mcard_spec_type_id)
      references base_member_card_type (member_card_type_id) on delete cascade on update cascade;

alter table base_mcard_spec add constraint FK_Reference_22 foreign key (mcard_spec_type_id)
      references base_member_card_type (member_card_type_id) on delete cascade;

alter table base_member add constraint FK_Reference_40 foreign key (member_user_id)
      references base_user (user_id) on delete restrict on update cascade;

alter table base_member add constraint FK_Reference_6 foreign key (member_studio_id)
      references base_studio (studio_id) on delete restrict;

alter table base_member_card_type add constraint FK_Reference_20 foreign key (member_card_type_studio_id)
      references base_studio (studio_id) on delete cascade;

alter table base_menu add constraint FK_Reference_8 foreign key (menu_pid)
      references base_menu (menu_id) on delete cascade on update cascade;

alter table base_menu_user_ref add constraint FK_Reference_10 foreign key (menu_user_user_id)
      references base_user (user_id) on delete cascade on update cascade;

alter table base_menu_user_ref add constraint FK_Reference_9 foreign key (menu_user_menu_id)
      references base_menu (menu_id) on delete cascade;

alter table base_plan_action add constraint FK_Reference_32 foreign key (plan_action_plan_id)
      references base_class_plan (class_plan_id) on delete cascade on update cascade;

alter table base_recharge add constraint FK_Reference_43 foreign key (recharge_mcard_id)
      references base_mcard (mcard_id) on delete cascade on update cascade;

alter table base_recharge add constraint FK_Reference_44 foreign key (recharge_user_id)
      references base_user (user_id) on delete restrict on update cascade;

alter table base_recharge add constraint FK_Reference_45 foreign key (recharge_spec_id)
      references base_mcard_spec (mcard_spec_id) on delete restrict on update restrict;

alter table base_sign add constraint FK_Reference_36 foreign key (sign_studio_id)
      references base_studio (studio_id) on delete restrict on update restrict;

alter table base_sign add constraint FK_Reference_41 foreign key (sign_member_id)
      references base_member (member_id) on delete restrict on update restrict;

alter table base_space add constraint FK_Reference_28 foreign key (space_studio_id)
      references base_studio (studio_id) on delete cascade on update cascade;

alter table base_studio add constraint FK_Reference_29 foreign key (studio_brand_id)
      references base_brand (brand_id) on delete cascade on update cascade;

alter table base_user add constraint FK_Reference_12 foreign key (user_studio_id)
      references base_studio (studio_id) on delete set null on update cascade;

alter table base_user add constraint FK_Reference_30 foreign key (user_brand_id)
      references base_brand (brand_id) on delete set null on update cascade;

alter table base_user_auth_ref add constraint FK_Reference_15 foreign key (user_auth_auth_id)
      references base_auth (auth_id) on delete cascade;

alter table base_user_auth_ref add constraint FK_Reference_17 foreign key (user_auth_user_id)
      references base_user (user_id) on delete cascade on update cascade;
