package tests;

import base.Vidfo;
import listeners.ResultListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.PermissionPage;

@Listeners(ResultListener.class)
public class PermissionTests extends Vidfo {

    @Test
    public void allowAllPermissions() {
        PermissionPage permission = new PermissionPage(driver);

        permission.allowPermission();
        permission.allowPermission();

        System.out.println("All permissions allowed");
    }

    @Test
    public void denyAllPermissions() {
        PermissionPage permission = new PermissionPage(driver);

        permission.denyPermission();
        permission.denyPermission();

        System.out.println("All permissions denied");
    }
}
