package com.greazi.bottemplate.database;

import com.greazi.bottemplate.BotTemplate;
import com.greazi.bottemplate.database.tables.*;
import org.jooq.DSLContext;

// TODO: Check all debug and error messages from all the database files

public class Database {

	public static DSLContext sql = BotTemplate.getSqlManager().getDslContext();

	public static MembersTable MEMBERSTable = new MembersTable();

}
