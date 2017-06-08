/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import Entity.Person;

/**
 *
 * @author christian
 */
public interface iFacade {
   void add(Person p); 
   void edit(Person p);
   Person find();
   void delete(Person p);
}
