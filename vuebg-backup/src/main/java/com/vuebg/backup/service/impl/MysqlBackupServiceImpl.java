package com.vuebg.backup.service.impl;

import com.vuebg.backup.service.IMysqlBackupService;
import com.vuebg.backup.utils.MySqlBackupRestoreUtils;
import org.springframework.stereotype.Service;

@Service
public class MysqlBackupServiceImpl implements IMysqlBackupService {

    @Override
    public boolean backup(String host, String userName, String password, String backupFolderPath, String fileName,
                          String database) throws Exception {
        return MySqlBackupRestoreUtils.backup("Linux", host, userName, password, backupFolderPath, fileName, database);
    }

    @Override
    public boolean restore(String restoreFilePath, String host, String userName, String password, String database)
            throws Exception {
        return MySqlBackupRestoreUtils.restore(restoreFilePath, host, userName, password, database);
    }
}
