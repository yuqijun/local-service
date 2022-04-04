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

 Date: 02/04/2022 10:32:01
*/


-- ----------------------------
-- Table structure for tb_goods
-- ----------------------------
DROP TABLE IF EXISTS "public"."tb_goods";
CREATE TABLE "public"."tb_goods" (
  "store_id" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
  "goods_id" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
  "goods_name" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
  "goods_description" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "goods_price" numeric(16,2) NOT NULL,
  "goods_sales_volume" int8 NOT NULL,
  "goods_number" int8 NOT NULL,
  "goods_avatar" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "create_time" timestamp(6) NOT NULL,
  "update_time" timestamp(6) NOT NULL,
  "remark" varchar(255) COLLATE "pg_catalog"."default",
  "group" varchar(30) COLLATE "pg_catalog"."default"
)
;
COMMENT ON COLUMN "public"."tb_goods"."store_id" IS '商店编号';
COMMENT ON COLUMN "public"."tb_goods"."goods_id" IS '商品编号';
COMMENT ON COLUMN "public"."tb_goods"."goods_name" IS '商品名称';
COMMENT ON COLUMN "public"."tb_goods"."goods_description" IS '商品描述';
COMMENT ON COLUMN "public"."tb_goods"."goods_price" IS '商品价格';
COMMENT ON COLUMN "public"."tb_goods"."goods_sales_volume" IS '商品销量';
COMMENT ON COLUMN "public"."tb_goods"."goods_number" IS '商品库存';
COMMENT ON COLUMN "public"."tb_goods"."goods_avatar" IS '商品图片';
COMMENT ON COLUMN "public"."tb_goods"."create_time" IS '记录创建时间';
COMMENT ON COLUMN "public"."tb_goods"."update_time" IS '记录更新时间';
COMMENT ON COLUMN "public"."tb_goods"."remark" IS '备注';
COMMENT ON COLUMN "public"."tb_goods"."group" IS '商品分类';
COMMENT ON TABLE "public"."tb_goods" IS '用户信息表';

-- ----------------------------
-- Records of tb_goods
-- ----------------------------
INSERT INTO "public"."tb_goods" VALUES ('10000001', '14', '涮鱼片200g', '鱼片', 14.00, 543, 99, 'https://t9.baidu.com/it/u=39350945,1142562492&fm=218&app=126&f=JPEG?w=121&h=75&s=B123D315DAA667224CADE8FB0300F037', '2022-04-01 15:06:15', '2022-04-01 15:06:29', NULL, '海鲜');
INSERT INTO "public"."tb_goods" VALUES ('10000001', '7', '金针菇', '菌盖滑嫩、柄脆、营养丰富、味美适口', 9.90, 543, 99, 'https://t7.baidu.com/it/u=998452245,2366682308&fm=218&app=126&f=JPEG?w=121&h=75&s=9DCA7F7E41126F6C5C4C106B0300E070', '2022-04-01 15:06:15', '2022-04-01 15:06:29', NULL, '新鲜果蔬');
INSERT INTO "public"."tb_goods" VALUES ('10000001', '10', '冷冻羊肉卷200g', '高级小羊肉', 29.00, 543, 99, 'https://dss3.baidu.com/-rVXeDTa2gU2pMbgoY3K/it/u=589266226,1983029730&fm=202&src=801', '2022-04-01 15:06:15', '2022-04-01 15:06:29', NULL, '肉卷');
INSERT INTO "public"."tb_goods" VALUES ('10000001', '10', '冷冻牛肉卷200g', '高级小牛肉', 25.00, 543, 99, 'https://fc3tn.baidu.com/it/u=3225912303,963546466&fm=202&src=801', '2022-04-01 15:06:15', '2022-04-01 15:06:29', NULL, '肉卷');
INSERT INTO "public"."tb_goods" VALUES ('10000001', '13', '乌鸡卷', '精品肉卷', 24.00, 543, 99, 'https://img0.baidu.com/it/u=406534508,2067187447&fm=253&fmt=auto&app=138&f=JPEG?w=794&h=500', '2022-04-01 15:06:15', '2022-04-01 15:06:29', NULL, '肉卷');
INSERT INTO "public"."tb_goods" VALUES ('10000001', '4', '豆腐干', '咸香爽口，硬中带韧，久放不坏', 12.00, 543, 99, 'https://t8.baidu.com/it/u=139020730,4003567191&fm=218&app=126&f=JPEG?https://t8.baidu.com/it/u=98536881,1503523095&fm=218&app=126&f=JPEG?w=121&h=75&s=333D7686219259D442072A6D0300A07A', '2022-04-01 15:06:15', '2022-04-01 15:06:29', NULL, '豆制品');
INSERT INTO "public"."tb_goods" VALUES ('10000001', '5', '花菜', '花椰菜营养丰富，富含蛋白质、脂肪、碳水化合物、食物纤维、多种维生素和钙、磷、铁等矿物质；性凉，味甘，助消化，增食欲，生津止渴', 13.00, 543, 99, 'https://fc1tn.baidu.com/it/u=3218584078,3635287561&fm=202&src=781&ernie_sim_online&mola=new&crop=v1', '2022-04-01 15:06:15', '2022-04-01 15:06:29', NULL, '新鲜果蔬');
INSERT INTO "public"."tb_goods" VALUES ('10000001', '6', '油麦菜', '油麦菜营养丰富、口感鲜嫩，生熟皆可食用', 12.00, 543, 99, 'https://img2.baidu.com/it/u=1732735138,3145522679&fm=253&fmt=auto&app=138&f=JPEG?w=640&h=360', '2022-04-01 15:06:15', '2022-04-01 15:06:29', NULL, '新鲜果蔬');
INSERT INTO "public"."tb_goods" VALUES ('10000001', '3', '黄瓜', '，形状美观，含水量为96%-98%，肉脆甜多汁，清香可口', 8.80, 543, 99, 'https://t8.baidu.com/it/u=139020730,4003567191&fm=218&app=126&f=JPEG?w=121&h=75&s=334CBD53A0B75786A619CE7403004067', '2022-04-01 15:06:15', '2022-04-01 15:06:29', NULL, '新鲜果蔬');
INSERT INTO "public"."tb_goods" VALUES ('10000001', '11', '甄选羊羔200g', '高级小羊肉', 39.00, 543, 99, 'https://fc6tn.baidu.com/it/u=2874882889,3026555275&fm=202&src=801', '2022-04-01 15:06:15', '2022-04-01 15:06:29', NULL, '肉卷');
INSERT INTO "public"."tb_goods" VALUES ('10000001', '15', '清水藕片', '有机蔬菜', 6.00, 543, 99, 'https://img0.baidu.com/it/u=2092352211,3044222512&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=316', '2022-04-01 15:06:15', '2022-04-01 15:06:29', NULL, '新鲜果蔬');
INSERT INTO "public"."tb_goods" VALUES ('10000001', '16', '火锅笋尖', '有机蔬菜', 9.90, 543, 99, 'https://paimgcdn.baidu.com/658797530FD58FF9?src=http%3A%2F%2Fms.bdimg.com%2Fdsp-image%2F11947551800.jpg&rz=urar_2_968_600&v=0', '2022-04-01 15:06:15', '2022-04-01 15:06:29', NULL, '新鲜果蔬');
INSERT INTO "public"."tb_goods" VALUES ('10000001', '17', '山药', '有机蔬菜', 8.60, 543, 99, 'https://fc1tn.baidu.com/it/u=2464295711,1325282335&fm=202&mola=new&crop=v1', '2022-04-01 15:06:15', '2022-04-01 15:06:29', NULL, '新鲜果蔬');
INSERT INTO "public"."tb_goods" VALUES ('10000001', '21', '牛筋丸', '手打丸子', 10.60, 543, 99, 'https://fc1tn.baidu.com/it/u=2328572072,901729000&fm=202&src=608&ernie_sim_online&mola=new&crop=v1', '2022-04-01 15:06:15', '2022-04-01 15:06:29', NULL, '丸子');
INSERT INTO "public"."tb_goods" VALUES ('10000001', '23', '香辣酱', '火锅调料', 4.00, 543, 99, 'https://t8.baidu.com/it/u=2389853381,4138259717&fm=218&app=126&f=JPEG?w=121&h=75&s=18305D97C2AB7AA576B268A40300A021', '2022-04-01 15:06:15', '2022-04-01 15:06:29', NULL, '火锅蘸料');
INSERT INTO "public"."tb_goods" VALUES ('10000001', '26', '花生碎', '火锅调料', 3.00, 543, 99, 'https://t9.baidu.com/it/u=3756456097,3731730775&fm=218&app=126&f=JPEG?w=121&h=75&s=D3AB9F45C595E9D248353C7A03009038', '2022-04-01 15:06:15', '2022-04-01 15:06:29', NULL, '火锅蘸料');
INSERT INTO "public"."tb_goods" VALUES ('10000001', '28', '混合芝麻酱', '火锅调料', 14.60, 543, 99, 'https://t7.baidu.com/it/u=477973688,627866375&fm=218&app=126&f=JPEG?w=121&h=75&s=49ABBB5543727D365E27496B03005038', '2022-04-01 15:06:15', '2022-04-01 15:06:29', NULL, '火锅蘸料');
INSERT INTO "public"."tb_goods" VALUES ('10000001', '29', '拉面400g', '主食', 8.00, 543, 99, 'https://t8.baidu.com/it/u=3946340083,3268680256&fm=218&app=126&f=JPEG?w=121&h=75&s=F51AA377857A7C3B8448586D0300E073', '2022-04-01 15:06:15', '2022-04-01 15:06:29', NULL, '主食');
INSERT INTO "public"."tb_goods" VALUES ('10000001', '31', '土豆粉', '主食', 4.00, 543, 99, 'https://fc1tn.baidu.com/it/u=596020436,2463748461&fm=202&src=766&ernie_sim_online&mola=new&crop=v1', '2022-04-01 15:06:15', '2022-04-01 15:06:29', NULL, '主食');
INSERT INTO "public"."tb_goods" VALUES ('10000001', '8', '青菜', '叶柄肥厚', 9.90, 543, 99, 'https://fc1tn.baidu.com/it/u=2977805856,2588759763&fm=202&src=608&ernie_sim_online&mola=new&crop=v1', '2022-04-01 15:06:15', '2022-04-01 15:06:29', NULL, '新鲜果蔬');
INSERT INTO "public"."tb_goods" VALUES ('10000001', '9', '麻辣牛肉', '麻辣鲜香，干香滋润化渣', 59.00, 543, 99, 'https://fc1tn.baidu.com/it/u=1856457057,1247442014&fm=202&src=766&ernie_sim_online&mola=new&crop=v1', '2022-04-01 15:06:15', '2022-04-01 15:06:29', NULL, '牛/羊肉');
INSERT INTO "public"."tb_goods" VALUES ('10000001', '12', '厚切雪花肥牛200g', '高级牛肉卷', 42.00, 543, 99, 'https://paimgcdn.baidu.com/7A24FE3664347DDB?src=http%3A%2F%2Fms.bdimg.com%2Fdsp-image%2F5656764191.jpg&rz=urar_2_968_600&v=0', '2022-04-01 15:06:15', '2022-04-01 15:06:29', NULL, '肉卷');
INSERT INTO "public"."tb_goods" VALUES ('10000001', '18', '虾滑', '手打丸子', 23.00, 543, 99, 'https://img1.baidu.com/it/u=75321161,799017028&fm=253&fmt=auto&app=138&f=JPEG?w=330&h=220', '2022-04-01 15:06:15', '2022-04-01 15:06:29', NULL, '丸子');
INSERT INTO "public"."tb_goods" VALUES ('10000001', '19', '包心鱼丸', '手打丸子', 6.00, 543, 99, 'https://fc1tn.baidu.com/it/u=3448781909,1199280485&fm=202&src=608&ernie_sim_online&mola=new&crop=v1', '2022-04-01 15:06:15', '2022-04-01 15:06:29', NULL, '丸子');
INSERT INTO "public"."tb_goods" VALUES ('10000001', '20', '蟹柳', '手打丸子', 17.00, 543, 99, 'https://t7.baidu.com/it/u=3731536854,634704566&fm=218&app=126&f=JPEG?w=121&h=75&s=36E6FC16D3F57F84439213A40300B028', '2022-04-01 15:06:15', '2022-04-01 15:06:29', NULL, '丸子');
INSERT INTO "public"."tb_goods" VALUES ('10000001', '22', '鱿鱼须', '新鲜海鲜', 19.00, 543, 99, 'https://t9.baidu.com/it/u=3554132781,925406321&fm=199&app=68&size=f121,75&n=0&g=0n&f=JPEG?s=4250CB226BFF27A7382500990300C092&sec=1957419205&t=5d582e0fe8977049b50dd42f63d425cc', '2022-04-01 15:06:15', '2022-04-01 15:06:29', NULL, '海鲜');
INSERT INTO "public"."tb_goods" VALUES ('10000001', '25', '香菇牛肉酱', '火锅调料', 4.00, 543, 99, 'https://t9.baidu.com/it/u=768679306,2280139829&fm=218&app=126&f=JPEG?w=121&h=75&s=9F104487C9922CC25E72E1A703004049', '2022-04-01 15:06:15', '2022-04-01 15:06:29', NULL, '火锅蘸料');
INSERT INTO "public"."tb_goods" VALUES ('10000001', '24', '火锅蘸料', '火锅调料', 4.60, 543, 99, 'https://paimgcdn.baidu.com/5EB70698DB3421D9?src=http%3A%2F%2Fms.bdimg.com%2Fdsp-image%2F12009573326.jpg&rz=urar_2_968_600&v=0', '2022-04-01 15:06:15', '2022-04-01 15:06:29', NULL, '火锅蘸料');
INSERT INTO "public"."tb_goods" VALUES ('10000001', '27', '沙茶酱', '火锅调料', 4.00, 543, 99, 'https://t7.baidu.com/it/u=3506964860,287451499&fm=190&app=60&f=JPEG?w=121&h=75&s=8988905D9A2326070301D13503005060', '2022-04-01 15:06:15', '2022-04-01 15:06:29', NULL, '火锅蘸料');
INSERT INTO "public"."tb_goods" VALUES ('10000001', '30', '宽粉', '主食', 5.60, 543, 99, 'https://fc1tn.baidu.com/it/u=3538091993,1206798005&fm=202&src=765&ernie_sim_online&mola=new&crop=v1', '2022-04-01 15:06:15', '2022-04-01 15:06:29', NULL, '主食');
INSERT INTO "public"."tb_goods" VALUES ('10000001', '32', '年糕300g', '主食', 4.00, 543, 99, 'https://fc1tn.baidu.com/it/u=3324351863,1872863755&fm=202&src=765&crossm&mola=new&crop=v1', '2022-04-01 15:06:15', '2022-04-01 15:06:29', NULL, '主食');
INSERT INTO "public"."tb_goods" VALUES ('10000001', '2', '木耳', '木耳质地柔软，口感细嫩，味道鲜美，风味特殊，而且富含蛋白质、脂肪、糖类及多种维生素和矿物质，有很高的营养价值，现代营养学家盛赞其为“素中之荤”。', 22.00, 543, 99, 'https://fc1tn.baidu.com/it/u=317145500,4075430648&fm=202&src=608&ernie_sim_online&mola=new&crop=v1', '2022-04-01 15:06:15', '2022-04-01 15:06:29', NULL, '新鲜蔬菜');
INSERT INTO "public"."tb_goods" VALUES ('10000001', '1', '油豆腐', '内如丝肉，细致绵空，富有弹性。系经磨浆、压坯、油炸等多道工序制作而成', 56.00, 543, 99, 'https://fc1tn.baidu.com/it/u=2147485065,3677664770&fm=202&src=762&ernie_sim_online&mola=new&crop=v1', '2022-04-01 15:06:15', '2022-04-01 15:06:29', NULL, '豆制品');
