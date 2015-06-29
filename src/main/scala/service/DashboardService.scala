package service


import java.time.format.DateTimeFormatter

import entity.{DashBoardTableEntity, Tables}
import infrastructure.DbDriver
import slick.driver.PostgresDriver.api._

import scala.concurrent.Await
import scala.concurrent.duration.Duration
import scala.util.{Failure, Success}

/**
 * @author mukai_masaki on 2015/06/27.
 */
class DashboardService {

  val hostMachineService = new HostMachineService()

  /**
   * ダッシュボードを表示するためのエンティティを返す.
   * @return
   */
  def makeDashboardEntity = {
    val q = Tables.HostBranch.result
    val future = DbDriver.db.run(q)
    Await.ready(future, Duration.Inf)
    val dashboardTableEntitySeq = future.value.get match {
      case Success(hostBranches) =>
        hostBranches map { hostBranch =>
          val hostMachineName = hostMachineService.fetchHostMachineName(hostBranch.hostMachineId.get)
          new DashBoardTableEntity(hostMachineName, hostBranch.branchName, hostBranch.deployTime)
        }
      case Failure(fb) => throw new RuntimeException
    }
    dashboardTableEntitySeq.sortBy(_.hostMachineName)
  }

}

object DashboardService{
  val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")
}