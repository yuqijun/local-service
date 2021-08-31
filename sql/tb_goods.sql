/*
 Navicat Premium Data Transfer

 Source Server         : 阿里云postgres
 Source Server Type    : PostgreSQL
 Source Server Version : 90602
 Source Host           : 101.132.143.228:5432
 Source Catalog        : eat
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 90602
 File Encoding         : 65001

 Date: 30/08/2021 14:11:40
*/


-- ----------------------------
-- Table structure for tb_goods
-- ----------------------------
DROP TABLE IF EXISTS "public"."tb_goods";
CREATE TABLE "public"."tb_goods" (
  "store_id" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
  "goods_id" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
  "goods_name" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
  "goods_discription" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "goods_price" numeric(16,2) NOT NULL,
  "goods_sales_volume" int8 NOT NULL,
  "goods_number" int8 NOT NULL,
  "goods_avatar" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "create_time" timestamp(6) NOT NULL,
  "update_time" timestamp(6) NOT NULL,
  "remark" varchar(255) COLLATE "pg_catalog"."default"
)
;
ALTER TABLE "public"."tb_goods" OWNER TO "postgres";
COMMENT ON COLUMN "public"."tb_goods"."store_id" IS '商店编号';
COMMENT ON COLUMN "public"."tb_goods"."goods_id" IS '商品编号';
COMMENT ON COLUMN "public"."tb_goods"."goods_name" IS '商品名称';
COMMENT ON COLUMN "public"."tb_goods"."goods_discription" IS '商品描述';
COMMENT ON COLUMN "public"."tb_goods"."goods_price" IS '商品价格';
COMMENT ON COLUMN "public"."tb_goods"."goods_sales_volume" IS '商品销量';
COMMENT ON COLUMN "public"."tb_goods"."goods_number" IS '商品库存';
COMMENT ON COLUMN "public"."tb_goods"."goods_avatar" IS '商品图片';
COMMENT ON COLUMN "public"."tb_goods"."create_time" IS '记录创建时间';
COMMENT ON COLUMN "public"."tb_goods"."update_time" IS '记录更新时间';
COMMENT ON COLUMN "public"."tb_goods"."remark" IS '备注';
COMMENT ON TABLE "public"."tb_goods" IS '用户信息表';

-- ----------------------------
-- Records of tb_goods
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Primary Key structure for table tb_goods
-- ----------------------------
ALTER TABLE "public"."tb_goods" ADD CONSTRAINT "tb_goods_pkey" PRIMARY KEY ("goods_id");
