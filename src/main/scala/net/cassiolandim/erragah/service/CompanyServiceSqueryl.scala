package net.cassiolandim.erragah.service

import org.squeryl.PrimitiveTypeMode._
import net.cassiolandim.erragah.Company
import net.cassiolandim.erragah.ErragahDb

class CompanyServiceSqueryl extends CompanyService {
  
  def insertCompany(c : Company) {
    inTransaction {
      ErragahDb.companies.insert(c)
    }
  }
  
  def updateCompany(c : Company) {
	  inTransaction {
      ErragahDb.companies.update(c)
    }
  }
  
  def find(id : Long): Option[Company] = {
    inTransaction {
      ErragahDb.companies.lookup(id)
    }
  }
}