/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.Project;
import entity.ProjectUser;

/**
 *
 * @author christian
 */
public interface iFacade {
    public String findProjects(String name);
    
    public void getAllUsers();
    
    public void getAllProjects();
    
    public void addUser(ProjectUser pu);
    
    public void addProject(Project p);
    
    public void delete(Project p);
}
