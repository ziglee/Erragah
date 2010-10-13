package net.cassiolandim.erragah.service

import net.cassiolandim.erragah.Company

trait CompanyService extends PersistableService[Company]{
  def insertCompany(c : Company)
  def updateCompany(c : Company)
}