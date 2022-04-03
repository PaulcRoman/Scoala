package ro.school.repository;

import java.sql.Connection;
import java.sql.Statement;

public interface RepoData {

         void connect();

         void exacuteStatement(String execute);

}
