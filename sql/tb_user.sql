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

 Date: 30/08/2021 14:12:08
*/


-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS "public"."tb_user";
CREATE TABLE "public"."tb_user" (
  "create_user_id" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
  "update_user_id" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
  "login_name" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
  "password" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
  "phone" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
  "email" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "id_no" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "province" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "city" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "region" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "county" varchar(100) COLLATE "pg_catalog"."default",
  "country" varchar(100) COLLATE "pg_catalog"."default",
  "village" varchar(100) COLLATE "pg_catalog"."default",
  "address" varchar(255) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "create_time" timestamp(6) NOT NULL,
  "update_time" timestamp(6) NOT NULL,
  "remark" varchar(255) COLLATE "pg_catalog"."default"
)
;
ALTER TABLE "public"."tb_user" OWNER TO "postgres";
COMMENT ON COLUMN "public"."tb_user"."create_user_id" IS '用户编号';
COMMENT ON COLUMN "public"."tb_user"."update_user_id" IS '修改人编号';
COMMENT ON COLUMN "public"."tb_user"."login_name" IS '登陆账号';
COMMENT ON COLUMN "public"."tb_user"."password" IS '登陆密码';
COMMENT ON COLUMN "public"."tb_user"."phone" IS '用户联系电话';
COMMENT ON COLUMN "public"."tb_user"."email" IS '用户邮箱';
COMMENT ON COLUMN "public"."tb_user"."id_no" IS '用户身份证号';
COMMENT ON COLUMN "public"."tb_user"."province" IS '省';
COMMENT ON COLUMN "public"."tb_user"."city" IS '市';
COMMENT ON COLUMN "public"."tb_user"."region" IS '区';
COMMENT ON COLUMN "public"."tb_user"."county" IS '县';
COMMENT ON COLUMN "public"."tb_user"."country" IS '乡';
COMMENT ON COLUMN "public"."tb_user"."village" IS '村';
COMMENT ON COLUMN "public"."tb_user"."address" IS '详细地址';
COMMENT ON COLUMN "public"."tb_user"."create_time" IS '记录创建时间';
COMMENT ON COLUMN "public"."tb_user"."update_time" IS '记录最后一次修改时间';
COMMENT ON COLUMN "public"."tb_user"."remark" IS '备注';
COMMENT ON TABLE "public"."tb_user" IS '用户信息表';

-- ----------------------------
-- Records of tb_user
-- ----------------------------
BEGIN;
INSERT INTO "public"."tb_user" VALUES ('10101010', '10101010', 'yuqijun123', '123456', '15625487985', '864784156@qq.com', '365125421325212412', '上海', '上海市', '闵行区', NULL, NULL, NULL, '虹梅路1188号', '2021-01-31 14:02:29', '2021-01-31 14:02:36', NULL);
COMMIT;

-- ----------------------------
-- Primary Key structure for table tb_user
-- ----------------------------
ALTER TABLE "public"."tb_user" ADD CONSTRAINT "tb_user_pkey" PRIMARY KEY ("create_user_id");
