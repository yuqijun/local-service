/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : PostgreSQL
 Source Server Version : 90624
 Source Host           : localhost:5432
 Source Catalog        : ls
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 90624
 File Encoding         : 65001

 Date: 02/04/2022 10:32:11
*/


-- ----------------------------
-- Table structure for tb_store
-- ----------------------------
DROP TABLE IF EXISTS "public"."tb_store";
CREATE TABLE "public"."tb_store" (
  "store_id" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
  "create_user_id" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
  "create_date_time" timestamp(6) NOT NULL,
  "update_user_id" varchar(20) COLLATE "pg_catalog"."default" NOT NULL,
  "update_date_time" timestamp(6) NOT NULL,
  "remark" varchar(255) COLLATE "pg_catalog"."default",
  "description" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "province" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "city" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "region" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "county" varchar(100) COLLATE "pg_catalog"."default",
  "country" varchar(100) COLLATE "pg_catalog"."default",
  "village" varchar(100) COLLATE "pg_catalog"."default",
  "address" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "telephone" varchar(30) COLLATE "pg_catalog"."default",
  "avatar" text COLLATE "pg_catalog"."default",
  "store_name" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
  "store_type_list" int4[] NOT NULL,
  "store_type_name_list" varchar[] COLLATE "pg_catalog"."default",
  "store_contact_list" jsonb,
  "user_name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "nick_name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "phone" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "store_source" varchar(5) COLLATE "pg_catalog"."default",
  "store_sales_volume" int8,
  "full_reduction_list" jsonb,
  "store_no_threshold_coupon" int2,
  "distribution_fee" varchar(255) COLLATE "pg_catalog"."default"
)
;
COMMENT ON COLUMN "public"."tb_store"."store_id" IS '主键  商店编号';
COMMENT ON COLUMN "public"."tb_store"."create_user_id" IS '用户编号';
COMMENT ON COLUMN "public"."tb_store"."create_date_time" IS '记录创建时间';
COMMENT ON COLUMN "public"."tb_store"."update_user_id" IS '修改人编号';
COMMENT ON COLUMN "public"."tb_store"."update_date_time" IS '最后一次修改时间';
COMMENT ON COLUMN "public"."tb_store"."remark" IS '备注';
COMMENT ON COLUMN "public"."tb_store"."description" IS '商店描述';
COMMENT ON COLUMN "public"."tb_store"."province" IS '省';
COMMENT ON COLUMN "public"."tb_store"."city" IS '市';
COMMENT ON COLUMN "public"."tb_store"."region" IS '区';
COMMENT ON COLUMN "public"."tb_store"."county" IS '县';
COMMENT ON COLUMN "public"."tb_store"."country" IS '乡';
COMMENT ON COLUMN "public"."tb_store"."village" IS '村';
COMMENT ON COLUMN "public"."tb_store"."address" IS '商店地址';
COMMENT ON COLUMN "public"."tb_store"."telephone" IS '商店联系电话';
COMMENT ON COLUMN "public"."tb_store"."avatar" IS '商店logo';
COMMENT ON COLUMN "public"."tb_store"."store_name" IS '商店名称';
COMMENT ON COLUMN "public"."tb_store"."store_type_list" IS '商店类型';
COMMENT ON COLUMN "public"."tb_store"."store_type_name_list" IS '商店类型描述';
COMMENT ON COLUMN "public"."tb_store"."store_contact_list" IS '商店联系人列表';
COMMENT ON COLUMN "public"."tb_store"."user_name" IS '用户实名姓名';
COMMENT ON COLUMN "public"."tb_store"."nick_name" IS '用户昵称';
COMMENT ON COLUMN "public"."tb_store"."phone" IS '用户电话';
COMMENT ON COLUMN "public"."tb_store"."store_source" IS '商店评分';
COMMENT ON COLUMN "public"."tb_store"."store_sales_volume" IS '全店销量';
COMMENT ON COLUMN "public"."tb_store"."full_reduction_list" IS '满减';
COMMENT ON COLUMN "public"."tb_store"."store_no_threshold_coupon" IS '无门槛优惠卷';
COMMENT ON COLUMN "public"."tb_store"."distribution_fee" IS '配送费';
COMMENT ON TABLE "public"."tb_store" IS '商店信息表';

-- ----------------------------
-- Records of tb_store
-- ----------------------------
INSERT INTO "public"."tb_store" VALUES ('10000001', '10101011', '2021-01-31 14:03:33', '10101011', '2021-01-31 14:03:40', NULL, '这家店不错，推荐！', '上海', '上海市', '闵行区', NULL, NULL, NULL, '虹梅路1132号', '856632544', 'https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png', '一品火锅店', '{1,3,5}', '{火锅店,奶茶店}', '[{"phone": "15623254789", "title": "经理", "user_name": "龙纹章", "responseible": "客户服务"}, {"phone": "15624155641", "title": "厨师", "user_name": "林译", "responseible": "出餐"}, {"phone": "15236547895", "title": "点餐员", "user_name": "孟烦了", "responseible": "为客户点餐"}, {"phone": "15651020325", "title": "杂工", "user_name": "迷龙", "responseible": "什么都敢"}]', '龙纹章', '三米之内', '15014254985', '3.7', 4, NULL, NULL, '3');
INSERT INTO "public"."tb_store" VALUES ('10000002', '10101012', '2021-01-31 14:03:34', '10101012', '2021-01-31 14:03:41', NULL, '味道一般般，分量很足', '上海', '上海市', '闵行区', NULL, NULL, NULL, '虹梅路1132号', '856632544', 'https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png', '一品火锅店分店', '{1,3,5}', '{火锅店,奶茶店}', '[{"phone": "15623254789", "title": "经理", "user_name": "何书光", "responseible": "客户服务"}, {"phone": "15624155641", "title": "厨师", "user_name": "林译", "responseible": "出餐"}, {"phone": "15236547895", "title": "点餐员", "user_name": "孟烦了", "responseible": "为客户点餐"}, {"phone": "15651020325", "title": "杂工", "user_name": "迷龙", "responseible": "什么都敢"}]', '虞啸卿', '团座大人', '15014254985', '4.3', 7, NULL, NULL, '4');
INSERT INTO "public"."tb_store" VALUES ('10000003', '10101013', '2021-01-31 14:03:35', '10101013', '2021-01-31 14:03:42', NULL, '味道一般般，分量很足', '上海', '上海市', '闵行区', NULL, NULL, NULL, '虹梅路1132号', '856632544', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2051319611,1917468632&fm=26&gp=0.jpg', '七杯茶', '{1,2}', '{奶茶店,甜品}', '[{"phone": "15623254789", "title": "经理", "user_name": "林译", "responseible": "客户服务"}, {"phone": "15624155641", "title": "厨师", "user_name": "林译", "responseible": "出餐"}, {"phone": "15236547895", "title": "点餐员", "user_name": "孟烦了", "responseible": "为客户点餐"}, {"phone": "15651020325", "title": "杂工", "user_name": "迷龙", "responseible": "什么都敢"}]', '张迷龙', '迷龙', '15014254985', '4.3', 7, NULL, NULL, '4');
INSERT INTO "public"."tb_store" VALUES ('10000005', '10101015', '2021-01-31 14:03:37', '10101015', '2021-01-31 14:03:44', NULL, '味道一般般，分量很足', '上海', '上海市', '闵行区', NULL, NULL, NULL, '虹梅路1132号', '856632544', 'https://dss1.bdstatic.com/6OF1bjeh1BF3odCf/it/u=1075833618,1813757768&fm=173&app=49&f=JPEG?w=312&h=208&s=F2B17DC80C91ACC0620D1A1C030050D6', '沙县小吃', '{3}', '{快餐}', '[{"phone": "15623254789", "title": "经理", "user_name": "张迷龙", "responseible": "客户服务"}, {"phone": "15624155641", "title": "厨师", "user_name": "林译", "responseible": "出餐"}, {"phone": "15236547895", "title": "点餐员", "user_name": "孟烦了", "responseible": "为客户点餐"}, {"phone": "15651020325", "title": "杂工", "user_name": "迷龙", "responseible": "什么都敢"}]', '孟凡了', '死瘸子', '15014254985', '4.3', 7, NULL, NULL, '4');
INSERT INTO "public"."tb_store" VALUES ('10000006', '10101016', '2021-01-31 14:03:38', '10101016', '2021-01-31 14:03:45', NULL, '味道一般般，分量很足', '上海', '上海市', '闵行区', NULL, NULL, NULL, '虹梅路1132号', '856632544', 'https://dss2.bdstatic.com/6Ot1bjeh1BF3odCf/it/u=1097582487,2493195583&fm=218&app=92&f=JPEG?w=121&h=75&s=4C86E812DCB529A3350DC1DC0300C022', '麻辣香锅', '{3}', '{快餐}', '[{"phone": "15623254789", "title": "经理", "user_name": "上官慈", "responseible": "客户服务"}, {"phone": "15624155641", "title": "厨师", "user_name": "林译", "responseible": "出餐"}, {"phone": "15236547895", "title": "点餐员", "user_name": "孟烦了", "responseible": "为客户点餐"}, {"phone": "15651020325", "title": "杂工", "user_name": "迷龙", "responseible": "什么都敢"}]', '上官慈', '嫂子', '15014254985', '4.3', 7, NULL, NULL, '4');
INSERT INTO "public"."tb_store" VALUES ('10000007', '10101017', '2021-01-31 14:03:39', '10101017', '2021-01-31 14:03:46', NULL, '味道一般般，分量很足', '上海', '上海市', '闵行区', NULL, NULL, NULL, '虹梅路1132号', '856632544', 'https://gss3.bdstatic.com/84oSdTum2Q5BphGlnYG/timg?wapp&quality=80&size=b150_150&subsize=20480&cut_x=0&cut_w=0&cut_y=0&cut_h=0&sec=1369815402&srctrace&di=311fca7d9be14ff1c589dcffcb3b3af8&wh_rate=null&src=http%3A%2F%2Fimgsrc.baidu.com%2Fforum%2Fpic%2Fitem%2Ffc1f4134970a304ef55c71bed3c8a786c9175c7c.jpg', '兰州拉面', '{3}', '{快餐}', '[{"phone": "15623254789", "title": "经理", "user_name": "董刀", "responseible": "客户服务"}, {"phone": "15624155641", "title": "厨师", "user_name": "林译", "responseible": "出餐"}, {"phone": "15236547895", "title": "点餐员", "user_name": "孟烦了", "responseible": "为客户点餐"}, {"phone": "15651020325", "title": "杂工", "user_name": "迷龙", "responseible": "什么都敢"}]', '马大志', '蛇屁股', '15014254985', '4.3', 7, NULL, NULL, '4');
INSERT INTO "public"."tb_store" VALUES ('10000008', '10101018', '2021-01-31 14:03:40', '10101018', '2021-01-31 14:03:47', NULL, '味道一般般，分量很足', '上海', '上海市', '闵行区', NULL, NULL, NULL, '虹梅路1132号', '856632544', 'https://dss0.bdstatic.com/6Ox1bjeh1BF3odCf/it/u=2570485872,671613008&fm=218&app=92&f=JPEG?w=121&h=75&s=0BC4ED0208912BE914A24B7D0300506F', '黄焖鸡', '{3}', '{快餐}', '[{"phone": "15623254789", "title": "经理", "user_name": "马大志", "responseible": "客户服务"}, {"phone": "15624155641", "title": "厨师", "user_name": "林译", "responseible": "出餐"}, {"phone": "15236547895", "title": "点餐员", "user_name": "孟烦了", "responseible": "为客户点餐"}, {"phone": "15651020325", "title": "杂工", "user_name": "迷龙", "responseible": "什么都敢"}]', '古小麦', '烧饼', '15014254985', '4.3', 7, NULL, NULL, '4');
INSERT INTO "public"."tb_store" VALUES ('10000009', '10101019', '2021-01-31 14:03:41', '10101019', '2021-01-31 14:03:48', NULL, '味道一般般，分量很足', '上海', '上海市', '闵行区', NULL, NULL, NULL, '虹梅路1132号', '856632544', 'https://dss3.baidu.com/-rVXeDTa2gU2pMbgoY3K/it/u=536608461,3017326869&fm=202&mola=new&crop=v1', '张良麻辣烫', '{4}', '{麻辣烫}', '[{"phone": "15623254789", "title": "经理", "user_name": "虞啸卿", "responseible": "客户服务"}, {"phone": "15624155641", "title": "厨师", "user_name": "林译", "responseible": "出餐"}, {"phone": "15236547895", "title": "点餐员", "user_name": "孟烦了", "responseible": "为客户点餐"}, {"phone": "15651020325", "title": "杂工", "user_name": "迷龙", "responseible": "什么都敢"}]', '郝兽医', '兽医', '15014254985', '4.3', 7, NULL, NULL, '4');
INSERT INTO "public"."tb_store" VALUES ('10000010', '10101020', '2021-01-31 14:03:42', '10101020', '2021-01-31 14:03:49', NULL, '味道一般般，分量很足', '上海', '上海市', '闵行区', NULL, NULL, NULL, '虹梅路1132号', '856632544', 'https://dss2.bdstatic.com/6Ot1bjeh1BF3odCf/it/u=1324019136,96045564&fm=74&app=80&f=JPEG&size=f121,121?sec=1880279984&t=33cf3ac8350d8a38182292f88d6ae60f', '山东烧饼', '{5}', '{烧饼}', '[{"phone": "15623254789", "title": "经理", "user_name": "余治", "responseible": "客户服务"}, {"phone": "15624155641", "title": "厨师", "user_name": "林译", "responseible": "出餐"}, {"phone": "15236547895", "title": "点餐员", "user_name": "孟烦了", "responseible": "为客户点餐"}, {"phone": "15651020325", "title": "杂工", "user_name": "迷龙", "responseible": "什么都敢"}]', '董刀', '丧门星', '15014254985', '4.3', 7, NULL, NULL, '4');
INSERT INTO "public"."tb_store" VALUES ('10000011', '10101021', '2021-01-31 14:03:43', '10101021', '2021-01-31 14:03:50', NULL, '味道一般般，分量很足', '上海', '上海市', '闵行区', NULL, NULL, NULL, '虹梅路1132号', '856632544', 'https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2344706454,3527032360&fm=26&gp=0.jpg', '云南米线', '{6}', '{米线}', '[{"phone": "15623254789", "title": "经理", "user_name": "张立宪", "responseible": "客户服务"}, {"phone": "15624155641", "title": "厨师", "user_name": "林译", "responseible": "出餐"}, {"phone": "15236547895", "title": "点餐员", "user_name": "孟烦了", "responseible": "为客户点餐"}, {"phone": "15651020325", "title": "杂工", "user_name": "迷龙", "responseible": "什么都敢"}]', '陈喝醉', '小醉', '15014254985', '4.3', 7, NULL, NULL, '4');
INSERT INTO "public"."tb_store" VALUES ('10000012', '10101022', '2021-01-31 14:03:44', '10101022', '2021-01-31 14:03:51', NULL, '味道一般般，分量很足', '上海', '上海市', '闵行区', NULL, NULL, NULL, '虹梅路1132号', '856632544', 'https://dss3.baidu.com/-rVXeDTa2gU2pMbgoY3K/it/u=1741093344,2383073238&fm=202&mola=new&crop=v1', '贵州米线', '{6}', '{米线}', '[{"phone": "15623254789", "title": "经理", "user_name": "张立宪", "responseible": "客户服务"}, {"phone": "15624155641", "title": "厨师", "user_name": "林译", "responseible": "出餐"}, {"phone": "15236547895", "title": "点餐员", "user_name": "孟烦了", "responseible": "为客户点餐"}, {"phone": "15651020325", "title": "杂工", "user_name": "迷龙", "responseible": "什么都敢"}]', '唐基', '老狐狸', '15014254985', '4.3', 7, NULL, NULL, '4');
INSERT INTO "public"."tb_store" VALUES ('10000004', '10101014', '2021-01-31 14:03:36', '10101014', '2021-01-31 14:03:43', NULL, '味道一般般，分量很足', '上海', '上海市', '闵行区', NULL, NULL, NULL, '虹梅路1132号', '856632544', 'https://bkimg.cdn.bcebos.com/pic/b3119313b07eca8004e6f6119d2397dda0448361?x-bce-process=image/watermark,image_d2F0ZXIvYmFpa2U5Mg==,g_7,xp_5,yp_5/format,f_auto', '喜茶', '{1,2}', '{奶茶店,甜品}', '[{"phone": "15623254789", "title": "经理", "user_name": "孟凡了", "responseible": "客户服务"}, {"phone": "15624155641", "title": "厨师", "user_name": "林译", "responseible": "出餐"}, {"phone": "15236547895", "title": "点餐员", "user_name": "孟烦了", "responseible": "为客户点餐"}, {"phone": "15651020325", "title": "杂工", "user_name": "迷龙", "responseible": "什么都敢"}]', '余治', '营长', '15014254985', '4.3', 7, NULL, NULL, '4');
