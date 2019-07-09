package com.htc.dao.impl;

import org.apache.commons.dbutils.QueryRunner;

import com.htc.utils.C3P0Utils;
import com.htc.utils.C3P0Utils2;

public abstract class BaseDaoImpl {
	protected QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
	protected QueryRunner queryRunner1 = new QueryRunner(C3P0Utils2.getDataSource());
}
