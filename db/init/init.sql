CREATE DATABASE IF NOT EXISTS `allclimb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT ENCRYPTION='N';
USE `allclimb`;

-- 계정생성
create user 'ac-black'@'%' identified by 'ac-black';

-- # 권한 부여
GRANT ALL PRIVILEGES ON allclimb.* TO 'ac-black'@'%';

-- # 권한 적용
FLUSH PRIVILEGES;

-- # 권한 부여 확인
SHOW GRANTS FOR 'ac-black'@'%';