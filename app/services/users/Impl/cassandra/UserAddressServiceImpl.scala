package services.users.Impl.cassandra

import domain.users.UserAddress
import services.users.UserAddressService

import scala.concurrent.Future

class UserAddressServiceImpl extends UserAddressService{
  override def saveEntity(entity: UserAddress): Future[Boolean] = ???

  override def getEntities: Future[Seq[UserAddress]] = ???

  override def getEntity(id: String): Future[Option[UserAddress]] = ???

  override def deleteEntity(entity: UserAddress): Future[Boolean] = ???

  override def createTable: Future[Boolean] = ???
}
